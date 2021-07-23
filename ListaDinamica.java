public class ListaDinamica implements Listavel {

	private int quantidade;
	private int tamanho;
	private NoDuplo ponteiroInicio;
	private NoDuplo ponteiroFim;

	public ListaDinamica() {
		this(10);
	}

	public ListaDinamica(int tamanho) {
		quantidade = 0;
		this.tamanho = tamanho;
		ponteiroInicio = null;
		ponteiroFim = null;
	}

	//anexar
	public void anexar(Object dado){
		if(!estaCheia()) {
			NoDuplo noTemporario = new NoDuplo();
			noTemporario.setDado(dado);
			if (!estaVazia()) {
				ponteiroFim.setProximo(noTemporario);
			} else  {
				ponteiroInicio = noTemporario;
			}
			noTemporario.setAnterior(ponteiroFim);
			ponteiroFim = noTemporario;

			quantidade++;
		} else {
			System.out.println("Fila Cheia!");
		}
	}


	//insere o novo dado fornecido na lista, numa posicao logica informada 
	public void inserir(int posicao, Object dado) {
		if(!estaCheia()) {
			if((posicao >= 0) && (posicao <= quantidade)) {
				NoDuplo noTemporario = new NoDuplo();
				noTemporario.setDado(dado);
				////////////////////////////////
				//Codigo de posicionamento do ponteiro auxiliar, no nodo
				//que serah feita alguma operacao. Lembrando que nesse metodo
				//auxiliar ira parar no nodo subsequente ao nodo que devera 
				//ser inserido				
				NoDuplo ponteiroAnterior = null;
				NoDuplo ponteiroAuxiliar = ponteiroInicio;
				NoDuplo ponteiroProximo = ponteiroAuxiliar;

				for (int i = 0; i < posicao; i++) {
					ponteiroAnterior = ponteiroAuxiliar;
					ponteiroAuxiliar = ponteiroAuxiliar.getProximo();
					ponteiroProximo = ponteiroAuxiliar;
				}

				if (ponteiroAnterior != null) {
					ponteiroAnterior.setProximo(noTemporario);
				//se o anterior é nulo é pq a insercao está sendo no inicio
				} else {
					ponteiroInicio = noTemporario;
				}

				if (ponteiroProximo != null) {
				ponteiroProximo.setAnterior(noTemporario);
				//se o proximo é nulo é pq a insercao está sendo no fim (append)
				} else {
					ponteiroFim = noTemporario;
				}
				
				noTemporario.setAnterior(ponteiroAnterior);
				noTemporario.setProximo(ponteiroProximo);

				quantidade++;
	        } else {
            	System.out.println("Posicao Inválida!");
            }
		} else {
			System.out.println("Lista Cheia!");
		}
	}
	
	//retorna o elemento que está numa posicao logica informada
	public Object selecionarUm(int posicao) {
		Object elementoTemporario = null;
		if (!estaVazia()) {
			if ((posicao >= 0) && (posicao < quantidade)) {
				////////////////////////////////
				//Codigo de posicionamento do ponteiro auxiliar, no nodo
				//que serah feita alguma operacao. Esse codigo eh o mesmo
				//para os metodos update, delete e select
				NoDuplo ponteiroAuxiliar = ponteiroInicio;
				for (int i = 0; i < posicao; i++) {
					ponteiroAuxiliar = ponteiroAuxiliar.getProximo();
				}
				///////////////////////////////
				elementoTemporario = ponteiroAuxiliar.getDado();
            } else {
                System.out.println("Posição Inválida!");
            }
		} else {
			System.out.println("Lista Vazia!");	
		}
		return elementoTemporario;
	}
	
	//substitui o elemento de uma posicao logica informada,
	//pelo novo elemento fornecido
	public void atualizar(int posicao, Object novoDado) {
		if (!estaVazia()) {
			if ((posicao >= 0) && (posicao < quantidade)) {
				////////////////////////////////
				//Codigo de posicionamento do ponteiro auxiliar, no nodo
				//que serah feita alguma operacao. Esse codigo eh o mesmo
				//para os metodos update, delete e select
				NoDuplo ponteiroAuxiliar = ponteiroInicio;
				for (int i = 0; i < posicao; i++) {
					ponteiroAuxiliar = ponteiroAuxiliar.getProximo();
				}
				///////////////////////////////
				ponteiroAuxiliar.setDado(novoDado);
            } else {
                System.out.println("Posição Inválida!");
            }
		} else {
			System.out.println("Lista Vazia!");	
		}
	}
	
	//remove o elemento de uma posicao logica informada
	public Object apagar(int posicao) {
		Object noTemporario = null;
		if (!estaVazia()) {
			if ((posicao >=0) && (posicao < quantidade)) {
				////////////////////////////////
				//Codigo de posicionamento do ponteiro auxiliar, no nodo
				//que serah feita alguma operacao. Esse codigo eh o mesmo
				//para os metodos update, delete e select
				NoDuplo ponteiroAuxiliar = ponteiroInicio;
				for (int i = 0; i < posicao; i++) {
					ponteiroAuxiliar = ponteiroAuxiliar.getProximo();
				}
				///////////////////////////////
				noTemporario = ponteiroAuxiliar.getDado();

				NoDuplo ponteiroAnterior = ponteiroAuxiliar.getAnterior();
				NoDuplo ponteiroProximo = ponteiroAuxiliar.getProximo();

				if (ponteiroAnterior != null) {
					ponteiroAnterior.setProximo(ponteiroProximo);
				//remocao do inicio, joga o ponteiro de inicio para o proximo nodo.
				} else {
					ponteiroInicio = ponteiroInicio.getProximo();
				}
				if (ponteiroProximo != null) {
					ponteiroProximo.setAnterior(ponteiroAnterior);
				//remocao do fim, joga o ponteiro de fim para o nodo anterior.
				} else {
					ponteiroFim = ponteiroFim.getAnterior();
				}

				quantidade--;
            } else {
                System.out.println("Posicão Inválida!");
            }
		} else {
			System.out.println("Lista Vazia!");	
		}	
		return noTemporario;	
	}

	//estaCheia
	public boolean estaCheia() {
		return (quantidade == tamanho);
	}

	//estaVazia
	public boolean estaVazia() {
		return (quantidade == 0);
	}

	//paraTexto
	public String imprimir() {
		NoDuplo ponteiroAuxiliar = ponteiroInicio;
		String conteudo = "[";
		for (int i = 0; i < quantidade; i++) {
		if (i == quantidade-1) {
				conteudo += ponteiroAuxiliar.getDado();
			} else {
				conteudo += ponteiroAuxiliar.getDado() + ",";
			}
			ponteiroAuxiliar = ponteiroAuxiliar.getProximo();
		}
		return conteudo + "]";
	}
}