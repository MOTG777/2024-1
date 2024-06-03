package banco.bd;

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		Pessoa p;
		String menu = "\n1-Cadastrar\n2-Atualizar\n3-Apagar\n4-Listar\n5-Mostrar um registro\n0-Sair\n\nDigite uma opção: ";
		String nome, fone, email; 
		int op, codigo;
		
		do{
			System.out.printf(menu);
			op = ler.nextInt();
			ler.nextLine();
			switch (op){
			case 1:
				System.out.printf("\nQual o nome que gostaria de inserir? ");
				nome = ler.nextLine();
				System.out.printf("\nQual o telefone de quem gostaria de inserir? ");
				fone = ler.nextLine();
				System.out.printf("\nQual o e-mail de quem gostaria de inserir? ");
				email = ler.nextLine();
				p = new Pessoa (); 
				p.setNome(nome); 
				p.setFone(fone); 
				p.setEmail(email); 
				p.inserir();

				break;
			case 2:
				System.out.printf("\nQual é o código de quem gostaria de atualizar? ");
				codigo = ler.nextInt();
				ler.nextLine();
				System.out.printf("\nPara qual nome gostaria de atualizar? ");
				nome = ler.nextLine();
				System.out.printf("\nPara qual telefone gostaria de atualizar? ");
				fone = ler.nextLine();
				System.out.printf("\nPara qual e-mail gostaria de atualizar? ");
				email = ler.nextLine();
				p = new Pessoa(); 
				p.setNome(nome); 
				p.setFone(fone); 
				p.setEmail(email); 
				p.setCodigo(codigo); 
				p.atualizar();
				break;
			case 3:
				System.out.printf("\nQual é o código de quem gostaria de apagar? ");
				codigo = ler.nextInt();
				p = new Pessoa ();
				p.setCodigo(codigo);
				p.apagar();
				break;
			case 4:
				p = new Pessoa(); 
				p.listar();
				break;
			case 5:
				System.out.printf("\nQual é o código de quem gostaria de visualizar? ");
				codigo = ler.nextInt();
				p = new Pessoa();
				p = p.mostraPorId(codigo);
				if (!p.getNome().equals("")) {
				System.out.printf("\nCódigo: %d", p.getCodigo());
				System.out.printf(" - Nome: %s", p.getNome());
				System.out.printf(" - Fone: %s", p.getFone());
				System.out.printf(" - Email: %s", p.getEmail());
				}
				else{
				System.out.printf("\nPessoa não encontrada!");
				}
				break;
			case 0:
				break;
			default:
				System.out.printf("\nOpção inválida!");
			}
			System.out.printf("\n");
		}while (op != 0);
		System.out.printf("\nPrograma encerrado.");
		ler.close();
	}
}
