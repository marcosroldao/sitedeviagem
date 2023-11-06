Algoritmo "Cadastro Boa Viagem"
// Disciplina   : Módulo 2 - Iniciação ao Mundo da Computação, Programação
// Professor   : Marcelo Vasquez
// Descrição   : Programa de cadastro de clientes de agência de turismo
// Autor(a)    : Marcos Roldão Xavier Português
// Data atual  : qua 26 07 2023

Var


   // Seção de Declarações das variáveis
   //Item: num
   //Nome completo: nome
   //CPF: cpf
   //Endereço: end
   //Telefone: tel
   //Destino: dest
   //Data:data


   num : vetor[1..3] de inteiro
   nome: vetor[1..3] de caracter
   cpf:  vetor[1..3] de caracter
   end:  vetor[1..3] de caracter
   tel:  vetor[1..3] de caracter
   dest: vetor[1..3] de caracter
   data: vetor[1..3] de caracter
   Opcao: inteiro
   quantidadeElementos: inteiro
   i: inteiro


   //-------------------TELA INICIAL---------------------------//



Inicio
   escreval("------------------------------------")
   escreval("Bem-vindo(a) à Boa Viagem Turismo!!!")
   escreval("------------------------------------")

   quantidadeElementos <- 1
   enquanto Opcao <> 3 faça

      escreval ("Digite o número da Opção desejada:")
      escreval
      escreval ("1.Cadastrar Cliente(s)")
      escreval ("2.Consultar Cliente(s) cadastrados")
      escreval ("3.Sair do Menu")
      escreval
      escreval ("Aguardando escolha da opção:")
      escreval("------------------------------------")


      escreval

      leia(Opcao)
      escolha Opcao

      caso 1
         se quantidadeElementos <= 3 entao

            limpatela

            escreval("________________________")
            escreval ("Digite o nome do cliente:")
            leia(nome [quantidadeElementos])

            escreval("________________________")
            escreval ("Digite o Cpf:")
            leia(cpf [quantidadeElementos])

            escreval("________________________")
            escreval ("Digite o endereço:")
            leia(end [quantidadeElementos])

            escreval("________________________")
            escreval ("Digite o n° do telefone:")
            leia(tel [quantidadeElementos])

            escreval("________________________")
            escreval ("Digite o destino:")
            leia(dest [quantidadeElementos])

            escreval("________________________")
            escreval ("Digite a data da viagem:")
            leia(data [quantidadeElementos])
            escreval("________________________")

            quantidadeElementos <- quantidadeElementos + 1

         senao
            escreval
            escreval ("Não é possivel adicionar mais clientes!")
            escreval("________________________")
         fimse


      caso 2

         se quantidadeElementos-1 >0 entao
            para i de 1 ate quantidadeElementos-1 faça
               escreval("____________________")
               escreval("Cliente n°",i,";")
               escreval("Nome: ", nome[i])
               escreval("Cpf: ", cpf[i])
               escreval("Endereço: ", end[i])
               escreval("Telefone: ", tel[i])
               escreval("Destino: ", dest[i])
               escreval("Data: ", data[i])
               escreval("____________________")

            fimpara

         senao
            escreval
            escreval( "Não existem clientes cadastrados!")
            escreval("________________________")
         fimse

      caso 3
         escreval("Saindo do programa..")
         limpatela


      OUTROCASO
         escreval("opcao invalida")
      fimescolha

   fimenquanto
fimalgoritmo






