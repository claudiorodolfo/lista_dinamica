public class ListaDinamicaPrincipal {
	public static void main(String[] args) {
		Listavel lista = new ListaDinamica();
		lista.anexar("A");
		System.out.println(lista.imprimir());
		lista.anexar("B");
		System.out.println(lista.imprimir());
		lista.inserir(2,"C");
		System.out.println(lista.imprimir());
		lista.anexar("D");
		System.out.println(lista.imprimir());
		lista.apagar(0);
		System.out.println(lista.imprimir());
		lista.inserir(0,"E");
		System.out.println(lista.imprimir());
		System.out.println(lista.selecionarUm(1));
		lista.atualizar(1,"E");
		System.out.println(lista.imprimir());
	}
}