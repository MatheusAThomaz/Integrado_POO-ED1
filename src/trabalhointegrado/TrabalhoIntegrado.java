/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhointegrado;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author matheus
 */
public class TrabalhoIntegrado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic 
        
        //CRIAÇÃO DAS ARVORES ORDENADAS PELOS NOMES E PELOS CODIGOS
        Arvore codigos = new Arvore();
        Arvore nomes = new Arvore();

        String nomearq = "ontologia.txt";
        String linha;

        String[] frase;
        String[] path1, path2;
        String newcode = null, nome, codigo, doenca1, doenca2 = null;
        
        //LEITURA DO ARQUIVO E INSERÇÃO NAS ARVORES NOMES E CODIGOS
        try {
            FileReader arq = new FileReader(nomearq);
            BufferedReader ler = new BufferedReader(arq);
            int i = 0;
            linha = ler.readLine();

            while (linha != null) {

                frase = linha.split(";");
                nome = frase[0];
                codigo = frase[1];

                No no = new No(nome, codigo);
                No cod = new No(nome, codigo);

                nomes.insereNome(no);

                //System.out.println(no.getNome());
                codigos.insereCodigo(cod);

                linha = ler.readLine();
            }

        } catch (IOException e) {

        }
        
        
        //NÓS CODE QUE AAUXILIAM NA BUSCA NA ARVORE DE NOMES
        No code1 = new No();
        No code2 = new No();

        
        //WHILE PARA LEITURA DE DOENÇAS NO TECLADO
        while (true) {
            
            System.out.println("Digite o nome das doenças: ");
            Scanner tec = new Scanner(System.in);
            doenca1 = tec.nextLine();
            
            if (doenca1.equals("")) {
                break;
            }
            
            code1 = nomes.findCode(nomes, doenca1);
            
            if (code1 != null) {
                doenca2 = tec.nextLine();
                if (doenca2.equals("")) {
                    break;
                }
                code2 = nomes.findCode(nomes, doenca2);
            
            if (code2 != null) {
           
                doenca1 = code1.getCodigo();
                doenca2 = code2.getCodigo();

                int i = 1, tam1 = 0, tam2 = 0, menor = 0;

                path1 = doenca1.split("\\.");
                path2 = doenca2.split("\\.");

                tam1 = path1.length;
                tam2 = path2.length;

                if (tam1 < tam2) {
                    menor = tam1;
                } else {
                    menor = tam2;
                }

                newcode = path1[0];

                while (i < menor && (path1[i].compareTo(path2[i])) == 0) {
                    newcode = newcode + ".";
                    newcode = newcode + path1[i];
                    i++;

                }

                No LCA;
                LCA = codigos.findNome(newcode);
                System.out.println(LCA.getNome());
            }
            else{
                   System.out.println("Doença não encontrada...");
            }
        }
            else{
                   System.out.println("Doença não encontrada...");
            }
        }
           System.out.println("Finalizado...");
        }

        
    }


