/**
 * @author Roberto Higor Matos dos Anjos
 */
package Codigo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ArmazenamentoArquivo implements Armazenamento {


	@Override
	public void armazenarPontos(int qtdPontos, String tipoPonto, String usuario) {
		File arquivo = new File("banco.txt");
		List<String> conteudoArquivo;

		if (!arquivo.exists())
			criarArquivo();

		try (FileWriter escrita = new FileWriter(arquivo, true)){
			conteudoArquivo = new ArrayList<>(Files.readAllLines(arquivo.toPath(), StandardCharsets.UTF_8));				
			String linhaUsuario = null;
			linhaUsuario = recuperarTodosOsPontos(usuario);
			//Se o usuário existe
			if (linhaUsuario == null) {
				escrita.write(usuario + " " + tipoPonto + " " + qtdPontos + "\n");									
			} else {
				alterarArquivo(qtdPontos, tipoPonto, usuario, arquivo, conteudoArquivo, linhaUsuario);
			}			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	private void alterarArquivo(int qtdPontos, String tipoPonto, String usuario, File arquivo,
			List<String> conteudoArquivo, String linhaUsuario) throws IOException {
		for (int i = 0; i < conteudoArquivo.size(); i++) {
			if (conteudoArquivo.get(i).equals(linhaUsuario)) {
				if (existeTipoPonto(tipoPonto, linhaUsuario)){
					conteudoArquivo.set(i, usuario + " " + tipoPonto + " " + (qtdPontos + getPontoDeTipo(tipoPonto, linhaUsuario)));
					break;
				}else {
					conteudoArquivo.set(i, conteudoArquivo.get(i) + ", " + tipoPonto + " " + qtdPontos);
				}
			}
		}
		Files.write(arquivo.toPath(), conteudoArquivo, StandardCharsets.UTF_8);
	}

	private void criarArquivo() {
		File arquivo = new File("banco.txt");
		try {
			arquivo.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<String> retornarTodosOsUsuariosComPontos() {
		List<String> listaUsuarios = new ArrayList<String>();
		List<String> linhas = lerLinhas();
		Pattern pattern = Pattern.compile("\\d");
			
		for (String linha : linhas) {			
			int pontos = 0;						
			String[] palavras = linha.split(" ");
			String usuario = palavras[0];			
			for (String palavra : palavras) {
				if (pattern.matcher(palavra).matches()) {					
					pontos += Integer.parseInt(palavra.replace(",", ""));					
				}
			}
			
			if (pontos > 0) {
				listaUsuarios.add(usuario);
			}
			
					
		}		
		return listaUsuarios;
	}

	@Override
	public int recuperarPontosUsuarioTipo(String usuario, String tipoPonto) {
	
			String linhaUsuario = null;
			if ((linhaUsuario = recuperarTodosOsPontos(usuario)) != null){
				return getPontoDeTipo(tipoPonto, linhaUsuario);
			}
			throw new UsuarioInexistenteException();
			
	
	}
	
	@Override
	public String recuperarTodosOsPontos(String usuario) {			
		List<String> linhas = lerLinhas();
		
		for (String linha : linhas) {
			String[] palavras = linha.split(" ");
			for (String palavra : palavras) {
				if (palavra.equals(usuario)){				
					return linha;
				}
			}	
		}
		return null;
	}

	private int getPontoDeTipo(String tipoPonto, String linhaUsuario) {
		String[] palavras = linhaUsuario.split(" ");

		for (int i = 0; i < palavras.length; i++) {
			if (palavras[i].equals(tipoPonto)) { 
				int pontos = Integer.parseInt(palavras[i+1].replace(",", ""));
				return pontos;
			}
		}

		return 0;
	}

	private Boolean existeTipoPonto(String tipoPonto, String linhaUsuario) {
		String[] palavras = linhaUsuario.split(" ");

		for (int i = 0; i < palavras.length; i++) {
			if (palavras[i].equals(tipoPonto)) 
				return true;
		}

		return false;
	}

	private List<String> lerLinhas() {
		File arquivo = new File("banco.txt");
		List<String> linhas = new ArrayList<String>();
		try (BufferedReader lerLinha = new BufferedReader(new FileReader(arquivo)))	{	
			String linha = null;
			while((linha= lerLinha.readLine()) != null) {
				linhas.add(linha);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return linhas;
	}
}
