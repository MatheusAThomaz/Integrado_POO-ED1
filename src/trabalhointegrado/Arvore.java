/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhointegrado;

/**
 *
 * @author matheus
 */
public class Arvore {

    private No raiz;
    private Arvore arvoreEsq;
    private Arvore arvoreDir;

    public Arvore() {
    }

    /*public void criaNome(String nome, String codigo) {
        No no = new No(nome, codigo);
        insereNome(no);
    }*/
    public void insereNome(No no) {
        String aux1, aux2;

        if (this.raiz == null) {
            this.raiz = no;
        } else {
            aux1 = no.getNome();
            aux2 = this.raiz.getNome();

            if (aux1.compareTo(aux2) > 0) {
                if (this.arvoreDir == null) {
                    this.arvoreDir = new Arvore();
                }
                this.arvoreDir.insereNome(no);
            } else {
                if (this.arvoreEsq == null) {
                    this.arvoreEsq = new Arvore();
                }

                this.arvoreEsq.insereNome(no);
            }
        }
    }

    public void insereCodigo(No no) {

        String aux1 = no.getCodigo();
        String aux2;

        if (this.raiz == null) {
            this.raiz = no;
        } else if (this.arvoreEsq == null) {   //System.out.println("1");
            this.arvoreEsq = new Arvore();
            this.arvoreEsq.insereCodigo(no);
        } else if (no.getCodigo().contains(this.arvoreEsq.raiz.getCodigo())==true) {
            this.arvoreEsq.insereCodigo(no);
        } else if(this.arvoreDir==null){
            this.arvoreDir = new Arvore();
            this.arvoreDir.insereCodigo(no);
        }
        else if (no.getCodigo().contains(this.arvoreDir.raiz.getCodigo())==true) {
            this.arvoreDir.insereCodigo(no);
        }

    }

    public No findNome(String codigo) {

        String aux1 = this.raiz.getCodigo();
        String aux2;

        if (this.raiz == null) {
            return this.raiz;
        } else if (this.raiz.getCodigo().compareTo(codigo) == 0) {
            return this.raiz;
        } else if (codigo.contains(this.arvoreEsq.raiz.getCodigo())) {

            return this.arvoreEsq.findNome(codigo);
        } else {
            return this.arvoreDir.findNome(codigo);
        }

    }

    public No findCode(Arvore a, String nome) {

        String aux1, aux2;
        if (a == null) {
            return null;
        } else {

            aux2 = this.raiz.getNome();

            if (nome.compareTo(aux2) > 0) {
                if (this.arvoreDir == null) {
                    return null;
                }
                else return this.arvoreDir.findCode(arvoreDir, nome);
            } else if (nome.compareTo(aux2) < 0) {
                if (this.arvoreEsq == null) {
                   return null;
                }

               else return this.arvoreEsq.findCode(arvoreEsq, nome);
            } else {
                return a.raiz;
            }

        }

    }

    public void teste(Arvore a) {
        if (a != null) {
            teste(a.arvoreEsq);
            System.out.println(a.raiz.getCodigo());
            teste(a.arvoreDir);
        }

    }

}
