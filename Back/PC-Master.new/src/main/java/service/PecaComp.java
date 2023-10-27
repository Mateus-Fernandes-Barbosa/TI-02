package service;

import model.Peca;
import dao.PecaDAO;
import dao.DAO;

import java.sql.*;
import java.util.List;


public class PecaComp extends Peca{

	private PecaDAO pecaDAO;
	
	public PecaComp() {
        super();
        pecaDAO = new PecaDAO();
    }
	
	public String retirarChaves(String inicial) {
		
		String string = "";
		
		for(int i = 2; i < inicial.length()-2; i++) {
			string += inicial.charAt(i);
		}
		return string;
	}

	//--|CLASSE PARA COMPARAR Pecas, IDENTIFICANDO QUAL A MELHOR DE ACORDO COM AS INFO.Especificas|--
		public void Comparacao(int x, int y){

			Peca pecaComparar1 = pecaDAO.get(x);
			Peca pecaComparar2 = pecaDAO.get(y);
			
			//---|VERIFICANDO A CATEGORIA DE CADA COMPONENTE PARA SER COMPARADO|---

			//Comparação de Processadores
			if(pecaComparar1.getCategoria().contains("Processador") && pecaComparar2.getCategoria().contains("Processador")){
				
				String Nome1 = pecaComparar1.getNome_componente();
				String Nome2 = pecaComparar2.getNome_componente();

				
				//Seperando a Informação Especifica
				String pecaProInfo1 = pecaComparar1.getInfo_especifica();
				String pecaProInfo2 = pecaComparar2.getInfo_especifica();
				
				String[]infoEspecificasX = pecaProInfo1.split(";");
				String[]infoEspecificasY = pecaProInfo2.split(";");
				
				
				int geracaoX = Integer.parseInt(infoEspecificasX[0]);
				int geracaoY = Integer.parseInt(infoEspecificasY[0]);
				
				String socketX = infoEspecificasX[1];
				String socketY = infoEspecificasY[1];
				
				String RAMX = infoEspecificasX[2];
				String RAMY = infoEspecificasY[2];
				
				int tamMaxRamX = Integer.parseInt(infoEspecificasX[3]);
				int tamMaxRamY = Integer.parseInt(infoEspecificasY[3]);
				
				int TDPX = Integer.parseInt(infoEspecificasX[4]);
				int TDPY = Integer.parseInt(infoEspecificasY[4]);
				
				String GPUX = infoEspecificasX[5];
				String GPUY = infoEspecificasY[5];
				
				int nucleosX = Integer.parseInt(infoEspecificasX[6]);
				int nucleosY = Integer.parseInt(infoEspecificasY[6]);
				
				int threadsX = Integer.parseInt(infoEspecificasX[7]);
				int threadsY = Integer.parseInt(infoEspecificasY[7]);
				
				double freqBaseX = Double.parseDouble(infoEspecificasX[8]);
				double freqMaxX = Double.parseDouble(infoEspecificasX[9]);
				
				double freqBaseY = Double.parseDouble(infoEspecificasY[8]);
				double freqMaxY = Double.parseDouble(infoEspecificasY[9]);
				
				//--|FAZENDO A CONDIÇÃO DE ACORDO COM A FREQUENCIA DO PROCESSADOR X e Y|--
				
				//Se Processador X possuir frequencia maior que Processador Y 
				if(freqBaseX > freqBaseY){
					
					System.out.println(Nome1 + " É um processador melhor que " + Nome2); 
					System.out.println("Isto devido á suas frequencias basicas: "); 
					
					System.out.println(Nome1 + " : " + freqBaseX); 
					System.out.println(Nome2 + " : " + freqBaseY); 
					
					//AVISAR SER CASO O OVERCLOCK FOR MELHOR QUE O OUTRO PROCESSADOR
					if(freqMaxX < freqMaxY){
						
						System.out.println("Porem, o processador " + Nome2 + " possui um overclock melhor que o " + Nome1); 
						System.out.println("Isto devido á suas frequencias maximas(overclock): "); 
						
						System.out.println(Nome1 + " : " + freqMaxX); 
						System.out.println(Nome2 + " : " + freqMaxY); 
					}
				}
				
				
				//Se Processador Y possuir frequencia maior que Processador X
				else if(freqBaseX < freqBaseY){
					
					System.out.println(Nome2 + " É um processador melhor que " + Nome1); 
					System.out.println("Isto devido á suas frequencias basicas: "); 
					
					System.out.println(Nome1 + " : " + freqBaseX); 
					System.out.println(Nome2 + " : " + freqBaseY); 
					
					//AVISAR SER CASO O OVERCLOCK FOR MELHOR QUE O OUTRO PROCESSADOR
					if(freqMaxX > freqMaxY){
						
						System.out.println("Porem, o processador " + Nome1 + " possui um overclock melhor que o " + Nome2); 
						System.out.println("Isto devido á suas frequencias maximas(overclock): "); 
						
						System.out.println(Nome1 + " : " + freqMaxX); 
						System.out.println(Nome2 + " : " + freqMaxY); 
					}
				}
				
				
				//--|CASO A FREQUENCIA DE AMBOS SEJA IGUAIS, SERÁ COMPARADO A QUANTIDADE DE NUCLEOS|--
				else if(freqBaseX == freqBaseY){
					
					
					//Se Processador X possuir mais nucleos que Processador Y 
					if(nucleosX > nucleosY){
						
						System.out.println(Nome1 + " É um processador melhor que " + Nome2); 
						System.out.println("Isto devido a quantidade de nucleos: "); 
						
						System.out.println(Nome1 + " : " + nucleosX); 
						System.out.println(Nome2 + " : " + nucleosY); 
						
						
						//AVISAR SER CASO O OUTRO PROCESSADOR POSSUIR MAIS THREADS
						if(threadsX < threadsY){
						
							System.out.println("Porem, o processador " + Nome2 + " possui mais threads que o " + Nome1); 
							
							System.out.println(Nome1 + " : " + threadsX); 
							System.out.println(Nome2 + " : " + threadsY); 
						}
						
					}
					
					//Se Processador Y possuir mais nucleos que Processador X
					else if(nucleosX < nucleosY){
						
						System.out.println(Nome2 + " É um processador melhor que " + Nome1); 
						System.out.println("Isto devido a sua quantidade de nucleos: "); 
						
						System.out.println(Nome1 + " : " + freqBaseX); 
						System.out.println(Nome2 + " : " + freqBaseY); 
						
						
						//AVISAR SER CASO O OUTRO PROCESSADOR POSSUIR MAIS THREADS
						if(threadsX > threadsY){
							
							System.out.println("Porem, o processador " + Nome1 + " possui mais threads que o " + Nome2); 
							System.out.println(Nome1 + " : " + threadsX); 
							System.out.println(Nome2 + " : " + threadsY); 
						}
						
					}
					
				}
				else{
					
					System.out.println("Ambos os processadores possuem a mesma perfomance."); 
				}
			}
			
			
			//Comparação de Placa de Videos
			else if(pecaComparar1.getCategoria().contains("Placa de Vídeo") && pecaComparar2.getCategoria().contains("Placa de Vídeo")){
				
				String Nome1 = pecaComparar1.getNome_componente();
				String Nome2 = pecaComparar2.getNome_componente();
				
				//Separando a Informação Especifica
				String pecaGPUInfo1 = pecaComparar1.getInfo_especifica();
				String pecaGPUInfo2 = pecaComparar2.getInfo_especifica();
				
				
				String[]infoEspecificasX = pecaGPUInfo1.split(";");
				String[]infoEspecificasY = pecaGPUInfo2.split(";");
				
				int TDPX = Integer.parseInt(infoEspecificasX[0]);
				int TDPY = Integer.parseInt(infoEspecificasY[0]);
				
				double pCLEX = Double.parseDouble(infoEspecificasX[1]);
				double pCLEY = Double.parseDouble(infoEspecificasY[1]);
				
				int vRAMX = Integer.parseInt(infoEspecificasX[2]);
				int vRAMY = Integer.parseInt(infoEspecificasY[2]);
				
				String tecRAMX = infoEspecificasX[3];
				String tecRAMY = infoEspecificasY[3];
						
				int baseClockX = Integer.parseInt(infoEspecificasX[4]);
				int baseClockY = Integer.parseInt(infoEspecificasY[4]);
							
				int boostClockX = Integer.parseInt(infoEspecificasX[5]);
				int boostClockY = Integer.parseInt(infoEspecificasY[5]);
							
				int memoryClockX = Integer.parseInt(infoEspecificasX[6]);
				int memoryClockY = Integer.parseInt(infoEspecificasY[6]);
							
				
				int qtdCoresX = Integer.parseInt(infoEspecificasX[7]);
				int qtdCoresY = Integer.parseInt(infoEspecificasY[7]);
				
				
				//COMPARANDO PLACA DE VIDEO DE ACORDO COM AS ESPECIFICAÇÕES
				if(qtdCoresX > qtdCoresY){
					
					System.out.println("A placa de vídeo " + Nome1 + " é mais rapida que a placa de vídeo " + Nome2); 
					System.out.println("Isto devido a quantidade de cores de cada uma: ");  
					
					System.out.println(Nome1 + " : " + qtdCoresX); 
					System.out.println(Nome2 + " : " + qtdCoresY); 
					
					//Avisar caso a outra placa possua uma frequencia maior.
					if(baseClockX < baseClockY){
						
						System.out.println("Porém, a placa de vídeo " + Nome2 + " possui uma frequencia basica maior que a " + Nome1); 
					
						System.out.println(Nome1 + " : " + baseClockX); 
						System.out.println(Nome2 + " : " + baseClockY); 
					}
				}
				
				else if(qtdCoresX < qtdCoresY){
					
					System.out.println("A placa de vídeo " + Nome2 + " é mais rapida que a placa de vídeo " + Nome1); 
					System.out.println("Isto devido a quantidade de cores de cada uma: ");  
					
					System.out.println(Nome1 + " : " + qtdCoresX); 
					System.out.println(Nome2 + " : " + qtdCoresY); 
					
					//Avisar caso a outra placa possua uma frequencia maior.
					if(baseClockX > baseClockY){
						
						System.out.println("Porém, a placa de vídeo " + Nome1 + " possui uma frequencia basica maior que a " + Nome2); 
					
						System.out.println(Nome1 + " : " + baseClockX); 
						System.out.println(Nome2 + " : " + baseClockY); 
					}
				}
				
				//CASO OS CORES SEJAM IGUAIS, COMPARAR A FREQUENCIA BASICA
				else if(qtdCoresX == qtdCoresY){
					
					if(baseClockX > baseClockY){
						
						System.out.println("A placa de vídeo " + Nome1 + " possui uma frequencia Basica maior que a " + Nome2); 
						
						System.out.println(Nome1 + " : " + baseClockX); 
						System.out.println(Nome2 + " : " + baseClockY); 
					}
					
					else if(baseClockX < baseClockY){
						
						System.out.println("A placa de vídeo " + Nome2 + " possui uma frequencia Basica maior que a " + Nome1); 
					
						System.out.println(Nome1 + " : " + baseClockX); 
						System.out.println(Nome2 + " : " + baseClockY); 
					}
					
					//CASO A FREQ.Basica SEJA IGUAL, COMPARAR A FREQ. Maxima
					else if(baseClockX == baseClockY){
						
						if(boostClockX > boostClockY){
							
							System.out.println("A placa de vídeo " + Nome1 + " possui uma frequencia Maxima maior que a " + Nome2); 
					
							System.out.println(Nome1 + " : " + boostClockX); 
							System.out.println(Nome2 + " : " + boostClockY); 
						}
						
						else if(boostClockX < boostClockY){
							
							System.out.println("A placa de vídeo " + Nome2 + " possui uma frequencia Maxima maior que a " + Nome1); 
					
							System.out.println(Nome1 + " : " + boostClockX); 
							System.out.println(Nome2 + " : " + boostClockY); 
						}
					}
					
					
				}
				
				//---|Caso perfomance seja igual|---
				else{
					
					System.out.println("Ambas Placa de Vídeos possuem a mesma perfomance"); 
				}
				
			}
			
			
			//Comparação de Placa Mães
			else if(pecaComparar1.getCategoria().contains("Placa Mãe") && pecaComparar2.getCategoria().contains("Placa Mãe")){
				
				String Nome1 = pecaComparar1.getNome_componente();
				String Nome2 = pecaComparar2.getNome_componente();
				
				//Separando as especificações
				String pecaMotherInfo1 = pecaComparar1.getInfo_especifica();
				String pecaMotherInfo2 = pecaComparar2.getInfo_especifica();
				
				String[]infoEspecificasX = pecaMotherInfo1.split(";");
				String[]infoEspecificasY = pecaMotherInfo2.split(";");
				
				
				String[] geracoesX = infoEspecificasX[0].split("/");
				String[] geracoesY = infoEspecificasY[0].split("/");
				
				int geracao1X = Integer.parseInt(geracoesX[0]);
				int geracao1Y = Integer.parseInt(geracoesY[0]);
				
				int geracao2X = Integer.parseInt(geracoesX[1]);
				int geracao2Y = Integer.parseInt(geracoesY[1]);
				
				String socketMotherX = infoEspecificasX[1];
				String socketMotherY = infoEspecificasY[1];
					
				String RAMMotherX = infoEspecificasX[2];
				String RAMMotherY = infoEspecificasY[2];
				
				int FreqRamX = Integer.parseInt(infoEspecificasX[3]);
				int FreqRamY = Integer.parseInt(infoEspecificasY[3]);
				
				int FreqRamMaxX = Integer.parseInt(infoEspecificasX[4]);
				int FreqRamMaxY = Integer.parseInt(infoEspecificasY[4]);
				
				double pCLEX = Double.parseDouble(infoEspecificasX[5]);
				double pCLEY = Double.parseDouble(infoEspecificasY[5]);
				
				int QtdSATAX = Integer.parseInt(infoEspecificasX[6]);
				int QtdSATAY = Integer.parseInt(infoEspecificasY[6]);
				
				int QtdM2X = Integer.parseInt(infoEspecificasX[7]);
				int QtdM2Y = Integer.parseInt(infoEspecificasY[7]);
				
				int QtdRAMX = Integer.parseInt(infoEspecificasX[8]);
				int QtdRAMY = Integer.parseInt(infoEspecificasY[8]);
				
				
				//FAZENDO A COMPARAÇÃO DE ACORDO COM QUANTIDADE DE PORTAS SATA
				if(QtdRAMX > QtdRAMY){
					
					System.out.println("A placa mãe " + Nome1 + " possui mais conectadores de memoria RAM que a placa " + Nome2); 
					
					System.out.println(Nome1 + " : " + QtdRAMX); 
					System.out.println(Nome2 + " : " + QtdRAMY); 
					
				}
				
				else if(QtdRAMX < QtdRAMY){
					
					System.out.println("A placa mãe " + Nome2 + " possui mais conectadores de memoria RAM que a placa " + Nome1); 
					
					System.out.println(Nome1 + " : " + QtdRAMX); 
					System.out.println(Nome2 + " : " + QtdRAMY); 
				}
				
				//CASO A Quantidade de RAM SEJAM IGUAIS, COMPARAR AS ENTRADAS SATAs
				else if(QtdRAMX == QtdRAMY){
					
					if(QtdSATAX > QtdSATAY){
						
						System.out.println("A placa mãe " + Nome1 + " possui mais entradas SATAs que a placa " + Nome2); 
					
						System.out.println(Nome1 + " : " + QtdSATAX); 
						System.out.println(Nome2 + " : " + QtdSATAY); 
					}
					
					else if(QtdSATAX < QtdSATAY){
						
						System.out.println("A placa mãe " + Nome2 + " possui mais entradas SATAs que a placa " + Nome1); 
					
						System.out.println(Nome1 + " : " + QtdSATAX); 
						System.out.println(Nome2 + " : " + QtdSATAY); 
					}
					
					//CASO A Quantidade de ENTRADAS SATAs SEJAM IGUAIS, COMPARAR A AS ENTRADAS M.2
					else if(QtdSATAX == QtdSATAY){
						
						if(QtdM2X > QtdM2Y){
							
							System.out.println("A placa mãe " + Nome1 + " possui mais entradas M.2 que a placa " + Nome2); 
					
							System.out.println(Nome1 + " : " + QtdM2X); 
							System.out.println(Nome2 + " : " + QtdM2Y); 
					}
						
						else if(QtdM2X < QtdM2Y){
							
							System.out.println("A placa mãe " + Nome2 + " possui mais entradas M.2 que a placa " + Nome1); 
					
							System.out.println(Nome1 + " : " + QtdM2X); 
							System.out.println(Nome2 + " : " + QtdM2Y); 
						}
					}	
					
				}
				
				//---|Caso perfomance seja igual|---
				else{
					
					System.out.println("Ambas Placa Mães possuem a mesma especificade (POSSUA ATENÇÃO ESPECIAL RELACIONADAS A COMPATIBILIDADE)"); 
				}
				
			}
			
			
			//Comparação de RAM
			else if(pecaComparar1.getCategoria().contains("Memória RAM") && pecaComparar2.getCategoria().contains("Memória RAM")){
				
				String Nome1 = pecaComparar1.getNome_componente();
				String Nome2 = pecaComparar2.getNome_componente();
				
				//Separando as especificações
				String pecaRAMInfo1 = pecaComparar1.getInfo_especifica();
				String pecaRAMInfo2 = pecaComparar2.getInfo_especifica();
				
				String[]infoEspecificasX = pecaRAMInfo1.split(";");
				String[]infoEspecificasY = pecaRAMInfo2.split(";");
				
				
				String tipoRamX = infoEspecificasX[0];
				String tipoRamY = infoEspecificasY[0];
				
				int frequenciaRamX = Integer.parseInt(infoEspecificasX[1]);
				int frequenciaRamY = Integer.parseInt(infoEspecificasY[1]);
				
				int tamRamX = Integer.parseInt(infoEspecificasX[2]);
				int tamRamY = Integer.parseInt(infoEspecificasY[2]);
				
				int latenciaX = Integer.parseInt(infoEspecificasX[3]);
				int latenciaY = Integer.parseInt(infoEspecificasY[3]);
				
				
				//FAZENDO A COMPARAÇÃO DE ACORDO COM O TAMANHO DA MEMORIA
				if(tamRamX > tamRamY){
					
					System.out.println("A RAM " + Nome1 + " possui mais memoria que a RAM " + Nome2); 
					
					System.out.println(Nome1 + " : " + tamRamX); 
					System.out.println(Nome2 + " : " + tamRamY); 
					
				}
				
				else if(tamRamX < tamRamY){
					
					System.out.println("A RAM " + Nome2 + " possui mais memoria que a RAM " + Nome1); 
					
					System.out.println(Nome1 + " : " + tamRamX); 
					System.out.println(Nome2 + " : " + tamRamY); 
				}
				
				//CASO O TAMANHO DA MEMORIA SEJA IGUAL, COMPARAR O TIPO
				else if(tamRamX == tamRamY){
					
					int resultado = tipoRamX.compareTo(tipoRamY);
					
					if(resultado > 0){
						
						System.out.println("A placa mãe " + Nome1 + " possui um tipo de memoria RAM melhor que a " + Nome2); 
					
						System.out.println(Nome1 + " : " + tipoRamX); 
						System.out.println(Nome2 + " : " + tipoRamY); 
					}
					
					else if(resultado < 0){
						
						System.out.println("A placa mãe " + Nome2 + " possui um tipo de memoria RAM melhor que a " + Nome1); 
					
						System.out.println(Nome1 + " : " + tipoRamX); 
						System.out.println(Nome2 + " : " + tipoRamY); 
					}
				}
				else{
					
					System.out.println("Ambas as memorias rams possuem as mesmas especifidades"); 
				}
				
			}
			
			
			//Comparação de Fonte
			else if(pecaComparar1.getCategoria().contains("Fontes") && pecaComparar2.getCategoria().contains("Fontes")){
				
				String Nome1 = pecaComparar1.getNome_componente();
				String Nome2 = pecaComparar2.getNome_componente();
				
				//Separando as especificações
				String[]infoEspecificasX = pecaComparar1.getInfo_especifica().split(";");
				String[]infoEspecificasY = pecaComparar2.getInfo_especifica().split(";");
				
				int potenciaX = Integer.parseInt(infoEspecificasX[0]);
				int potenciaY = Integer.parseInt(infoEspecificasY[0]);
				
				String seloX = infoEspecificasX[1];
				String seloY = infoEspecificasY[1];
				
				//METODO PARA COMPARAR O SELO PLUS DAS FONTES
				int compSeloX;
				int compSeloY;

				if(seloX.contains("Bronze")){ compSeloX = 0; }
				else if(seloX.contains("White")){ compSeloX = 1; }
				else if(seloX.contains("Gold")){ compSeloX = 2;}
				else{ compSeloX = -1;}
				
				if(seloY.contains("Bronze")){ compSeloY = 0; }
				else if(seloY.contains("White")){ compSeloY = 1; }
				else if(seloY.contains("Gold")){ compSeloY = 2;}
				else{ compSeloY = -1;}
				
				
				//COMPARANDO DE ACORDO COM O SELO
				if(compSeloX > compSeloY){
					
					System.out.println("A fonte " + Nome1 + " é melhor que a fonte " + Nome2); 
					
					System.out.println(Nome1 + " : " + seloX); 
					System.out.println(Nome2 + " : " + seloY); 
				}
				else if(compSeloX < compSeloY){
					
					System.out.println("A fonte " + Nome2 + " é melhor que a fonte " + Nome1); 
					
					System.out.println(Nome1 + " : " + seloX); 
					System.out.println(Nome2 + " : " + seloY); 
				}
				else{
					
					System.out.println("Ambas as fontes possuem a mesma qualidade (ATENÇÃO COM A POTENCIA NECESSÁRIA)"); 
				}
				
			}
			
			else {
				
				System.out.println("Ambos os componentes devem ser da mesma categoria/componente para ser feito a comparação"); 
			}
			
		}
		
		
		//-----| COMPATIBILIDADE DE Pecas |------
		
			//---|Compatibilidade entre Processador e Placa Mãe|---
			public void CompatibilidadeProcessadorMotherBoard(int x, int y){
				
				Peca pecaCompatibilidade1 = pecaDAO.get(x);
				Peca pecaCompatibilidade2 = pecaDAO.get(y);
				
				
				//--|VERIFICANDO QUAL O TIPO DE COMPATIBILIDADE DEVE SER FEITA|--
				
				if(pecaCompatibilidade1.getCategoria().contains("Processador") && pecaCompatibilidade2.getCategoria().contains("Placa Mãe")){
					
					String Nome1 = pecaCompatibilidade1.getNome_componente();
					String Nome2 = pecaCompatibilidade2.getNome_componente();
					
					//Seperando as informações especificas do Processador e da Placa Mae
					String pecaInfo1 = pecaCompatibilidade1.getInfo_especifica();
					String pecaInfo2 = pecaCompatibilidade2.getInfo_especifica();
					
					String[]ProcessInfo = pecaInfo1.split(";");
					String[]MotherBInfo = pecaInfo2.split(";");
					
					
					//Especificações do Processador
					
					int geracaoPro = Integer.parseInt(ProcessInfo[0]);
					
					String socketPro = ProcessInfo[1];
					String RAMPro = ProcessInfo[2];
					
					int tamMaxRamPro = Integer.parseInt(ProcessInfo[3]);
					int TDPPo = Integer.parseInt(ProcessInfo[4]);
					
					String GPUPro = ProcessInfo[5];
					
					int nucleosPro = Integer.parseInt(ProcessInfo[6]);
					int threadsPro = Integer.parseInt(ProcessInfo[7]);
					double freqBasePro = Double.parseDouble(ProcessInfo[8]);
					double freqMaxPro = Double.parseDouble(ProcessInfo[9]);
					
					//---------------------------------------------------
					
					//Especificações da Placa Mãe
					
					//Condicao especial caso a placa mae NAO POSSUI COMPATIBILIDADE COM 2 PROCESSADORES
			
					String[] geracoes = MotherBInfo[0].split("/");
					int geracao1 = Integer.parseInt(geracoes[0]);
					int geracao2 = Integer.parseInt(geracoes[1]);
					
					String socketMother = MotherBInfo[1];
						
					//ESPECIFICAÇÕES NÃO NECESSÁRIAS APENAS PARA PROCESSADOR -> PLACA MÃE
					String RAMMother = MotherBInfo[2];
					
					int FreqRam = Integer.parseInt(MotherBInfo[3]);
					int FreqRamMax = Integer.parseInt(MotherBInfo[4]);
					double pCLE = Double.parseDouble(MotherBInfo[5]);
					int QtdSATA = Integer.parseInt(MotherBInfo[6]);
					int QtdM2 = Integer.parseInt(MotherBInfo[7]);
					int QtdRAM = Integer.parseInt(MotherBInfo[8]);
					//-------------------------------------------------------------------
					
					if(((geracaoPro == geracao1) || (geracaoPro == geracao2)) && (socketPro.contains(socketMother))){
						
						System.out.println("O processador " + Nome1 + " É compativel com a Placa Mãe " + Nome2); 
						
						System.out.println(Nome1 + " : " + geracaoPro); 
						System.out.println(Nome2 + " : " + geracao1 + "/" + geracao2 + "\n"); 
						
						System.out.println(Nome1 + " : " + socketPro); 
						System.out.println(Nome2 + " : " + socketMother); 
					}
					else{
						
						System.out.println("O processador " + Nome1 + " NAO é compativel com a Placa Mãe " + Nome2); 
						
						System.out.println(Nome1 + " : " + geracaoPro); 
						System.out.println(Nome2 + " : " + geracao1 + "/" + geracao2 + "\n"); 
						
						System.out.println(Nome1 + " : " + socketPro); 
						System.out.println(Nome2 + " : " + socketMother); 
						
					}
					
					if(GPUPro.contains("NAO")){
						
						System.out.println("Como este processador não possui uma GPU integrada. Caso não haja uma placa de vídeo, o computador irá ligar, mas não possuirá vídeo. Sendo assim inutilizavel"); 
					}
					
				}
				
			}
			
			/*EM COMPATIBILIDADE, É SEGUIDO UMA REGRA. NO QUAL PARA SER FEITO A COMPATIBILIDADE DE 3 COMPONENTES. 
			O PRIMEIRO COMPONENTE DEVE SER UM PROCESSADOR(Index de [0 a 4]). 
			O SEGUNDO A PLACA DE VÍDEO OU MEMORIA RAM (Index de [5 a 9] \ [15 a 19]
			O TERCEIRO DEVE SER A PLACA MAE OU A FONTE(Index de [10 a 14] \ [20 a 24]
		
			EXEMPLO:
			Compatibilidade entre Processador, Placa de Vídeo e Placa Mãe ---> (Peça com categoria de Processador, Peça com categoria de Placa de Video, Peça com categoria de Placa Mae)
		
			*/
			
			public void Compatibilidade(int x, int y, int z){
				
				Peca pecaCompatibilidade1 = pecaDAO.get(x);
				Peca pecaCompatibilidade2 = pecaDAO.get(y);
				Peca pecaCompatibilidade3 = pecaDAO.get(z);

				
				//-------|COMPATIBILIDADE ENTRE PROCESSADOR, PLACA DE VIDEO E PLACA MAE|-------
				if(pecaCompatibilidade1.getCategoria().contains("Processador") && pecaCompatibilidade2.getCategoria().contains("Placa de Vídeo") && pecaCompatibilidade3.getCategoria().contains("Placa Mãe")){
					
					String Nome1 = pecaCompatibilidade1.getNome_componente();
					String Nome2 = pecaCompatibilidade2.getNome_componente();
					String Nome3 = pecaCompatibilidade3.getNome_componente();
					
					
					//Separando as informações especificas
					
					String pecaInfo1 = pecaCompatibilidade1.getInfo_especifica();
					String pecaInfo2 = pecaCompatibilidade2.getInfo_especifica();
					String pecaInfo3 = pecaCompatibilidade3.getInfo_especifica();

					
					String[]ProcessInfo = pecaInfo1.split(";");
					String[]PlacaVideo	= pecaInfo2.split(";");
					String[]MotherBInfo	= pecaInfo3.split(";");
					
					//Especificações do Processador
					int geracaoPro = Integer.parseInt(ProcessInfo[0]);
					
					String socketPro = ProcessInfo[1];
					String RAMPro = ProcessInfo[2];
					
					int tamMaxRam = Integer.parseInt(ProcessInfo[3]);
					int TDPPro = Integer.parseInt(ProcessInfo[4]);
					
					String GPU = ProcessInfo[5];
					
					int nucleos = Integer.parseInt(ProcessInfo[6]);
					int threads = Integer.parseInt(ProcessInfo[7]);
					double freqBase = Double.parseDouble(ProcessInfo[8]);
					double freqMax = Double.parseDouble(ProcessInfo[9]);
					
					//--------
					
					//Especificações da Placa de Video
					int TDPv = Integer.parseInt(PlacaVideo[0]);
					double pCLEVideo = Double.parseDouble(PlacaVideo[1]);
					int vRAMV = Integer.parseInt(PlacaVideo[2]);
					
					String tecRAMV = PlacaVideo[3];
					
					int baseClockV = Integer.parseInt(PlacaVideo[4]);						
					int boostClockV = Integer.parseInt(PlacaVideo[5]);						
					int memoryClockV = Integer.parseInt(PlacaVideo[6]);						
					int qtdCoresV = Integer.parseInt(PlacaVideo[7]);
					
					//--------
					
					//Especificações da Placa Mãe
					
					//Condicao especial caso a placa mae NAO POSSUI COMPATIBILIDADE COM 2 PROCESSADORES
					if((MotherBInfo[0].contains("/")) == false ){
						
						int geracaoMother = Integer.parseInt(MotherBInfo[0]);
					}
					
					else{
						
						String[] geracoes = MotherBInfo[0].split("/");
						int geracao1 = Integer.parseInt(geracoes[0]);
						int geracao2 = Integer.parseInt(geracoes[1]);
					}
					
					String socketMother = MotherBInfo[1];
					String RAMMother = MotherBInfo[2];
					
					int FreqRam = Integer.parseInt(MotherBInfo[3]);
					int FreqRamMax = Integer.parseInt(MotherBInfo[4]);
					double pCLEMother = Double.parseDouble(MotherBInfo[5]);
					int QtdSATA = Integer.parseInt(MotherBInfo[6]);
					int QtdM2 = Integer.parseInt(MotherBInfo[7]);
					int QtdRAM = Integer.parseInt(MotherBInfo[8]);
					//------------------------
					
					//---|CONDIÇÃO DE COMPATIBILIDADE (PLACA MÃE E PLACA DE VIDEO)|---
					//Compatibilidade de acordo com a tecnologia pCLE
					if(pCLEMother > pCLEVideo){
						
						System.out.println("A placa de Vídeo " + Nome2 + " é compativel com " + Nome3); 
						System.out.println("Isto porque a tecnologia da entrada pCLE da placa mae é maior que da placa de vídeo"); 
						System.out.println("----\nPlaca de video : " + Nome2 + " - pCLE : " +  pCLEVideo); 
						System.out.println("Placa Mãe : " + Nome3 + " - pCLE : " +  pCLEMother); 
					}
					else if (pCLEMother == pCLEVideo){
						
						System.out.println("A placa de Vídeo " + Nome2 + " é compativel com " + Nome3); 
						System.out.println("Isto porque a tecnologia da entrada pCLE da placa mae é igual que da placa de vídeo"); 
						System.out.println("----\nPlaca de video : " + Nome2 + " - pCLE : " +  pCLEVideo); 
						System.out.println("Placa Mãe : " + Nome3 + " - pCLE : " +  pCLEMother); 
						
					}
					else{
						
						System.out.println("A placa de Vídeo " + Nome2 + " é compativel com " + Nome3); 
						
						System.out.println("POREM, a placa nao será usada 100%"); 
						
						System.out.println("Isto porque a tecnologia da entrada pCLE da placa mae é menor que da placa de vídeo"); 
						System.out.println("----\nPlaca de video : " + Nome2 + " - pCLE : " +  pCLEVideo); 
						System.out.println("Placa Mãe : " + Nome3 + " - pCLE : " +  pCLEMother); 
					
					}
					
				}
				
				
				//-------|COMPATIBILIDADE ENTRE PROCESSADOR, MEMORIA RAM E PLACA MAE|----------
				else if(pecaCompatibilidade1.getCategoria().contains("Processador") && pecaCompatibilidade2.getCategoria().contains("Memória RAM") && pecaCompatibilidade3.getCategoria().contains("Placa Mãe")){
					
					String Nome1 = pecaCompatibilidade1.getNome_componente();
					String Nome2 = pecaCompatibilidade2.getNome_componente();
					String Nome3 = pecaCompatibilidade3.getNome_componente();
					
					//Separando as informações especificas
					
					String pecaInfo1 = pecaCompatibilidade1.getInfo_especifica();
					String pecaInfo2 = pecaCompatibilidade2.getInfo_especifica();
					String pecaInfo3 = pecaCompatibilidade3.getInfo_especifica();
					
					String[]ProcessInfo = pecaInfo1.split(";");
					String[]MemRamInfo 	= pecaInfo2.split(";");
					String[]MotherBInfo	 = pecaInfo3.split(";");
					
					//Especificações do Processador
					int geracaoPro = Integer.parseInt(ProcessInfo[0]);
					
					String socketPro = ProcessInfo[1];
					String RAMPro = ProcessInfo[2];
					
					int tamMaxRam = Integer.parseInt(ProcessInfo[3]);
					int TDPPro = Integer.parseInt(ProcessInfo[4]);
					
					String GPU = ProcessInfo[5];
					
					int nucleos = Integer.parseInt(ProcessInfo[6]);
					int threads = Integer.parseInt(ProcessInfo[7]);
					double freqBase = Double.parseDouble(ProcessInfo[8]);
					double freqMax = Double.parseDouble(ProcessInfo[9]);
					
					//--------
					
					//Especificações da Memoria RAM
					
					String tipoRam = MemRamInfo[0];

					int frequenciaRam = Integer.parseInt(MemRamInfo[1]);
					int tamRam = Integer.parseInt(MemRamInfo[2]);
					int latencia = Integer.parseInt(MemRamInfo[3]);
					
					//--------
					
					//Especificações da Placa Mãe
					
					//Condicao especial caso a placa mae NAO POSSUI COMPATIBILIDADE COM 2 PROCESSADORES
					if((MotherBInfo[0].contains("/")) == false ){
						
						int geracaoMother = Integer.parseInt(MotherBInfo[0]);
					}
					
					else{
						
						String[] geracoes = MotherBInfo[0].split("/");
						int geracao1 = Integer.parseInt(geracoes[0]);
						int geracao2 = Integer.parseInt(geracoes[1]);
					}
					
					String socketMother = MotherBInfo[1];
					String RAMMother = MotherBInfo[2];
					
					int FreqRam = Integer.parseInt(MotherBInfo[3]);
					int FreqRamMax = Integer.parseInt(MotherBInfo[4]);
					double pCLEMother = Double.parseDouble(MotherBInfo[5]);
					int QtdSATA = Integer.parseInt(MotherBInfo[6]);
					int QtdM2 = Integer.parseInt(MotherBInfo[7]);
					int QtdRAM = Integer.parseInt(MotherBInfo[8]);
					
					//------------------------------
					
					//Verificando compatibilidade de acordo com o tipo de RAM
					
					if(tipoRam.contains(RAMPro) && tipoRam.contains(RAMMother)){
						
						System.out.println("A memoria RAM é compativel com a placa mãe e com o processador"); 
						System.out.println("Isto porque o tipode de RAM é o mesmo dos outros dois componentes"); 
						
						System.out.println("---\nMemoria RAM : " + Nome2 + " - Tipo de RAM : " + tipoRam); 
						System.out.println("Processador : " + Nome1 + " - Tipo de RAM : " + RAMPro); 
						System.out.println("Placa Mae : " + Nome3 + " - Tipo de RAM : " + RAMMother); 
					}
					else{
						
						System.out.println("A memoria RAM NAO é compativel com a placa mãe e com o processador"); 
						System.out.println("Isto porque o tipode de RAM NAO é o mesmo dos outros dois componentes. Confira abaixo"); 
						
						System.out.println("---\nMemoria RAM : " + Nome2 + " - Tipo de RAM : " + tipoRam); 
						System.out.println("Processador : " + Nome1 + " - Tipo de RAM : " + RAMPro); 
						System.out.println("Placa Mae : " + Nome3 + " - Tipo de RAM : " + RAMMother); 
					}
					
				}
				
				
				//-------|COMPATIBILIDADE ENTRE PROCESSADOR, PLACA DE VIDEO E FONTES|-----
				else if(pecaCompatibilidade1.getCategoria().contains("Processador") && pecaCompatibilidade2.getCategoria().contains("Placa de Vídeo") && pecaCompatibilidade3.getCategoria().contains("Fontes")){
				
					String Nome1 = pecaCompatibilidade1.getNome_componente();
					String Nome2 = pecaCompatibilidade2.getNome_componente();
					String Nome3 = pecaCompatibilidade3.getNome_componente();
					
					//Separando as informações especificas
					
					String pecaInfo1 = pecaCompatibilidade1.getInfo_especifica();
					String pecaInfo2 = pecaCompatibilidade2.getInfo_especifica();
					String pecaInfo3 = pecaCompatibilidade3.getInfo_especifica();
					
					
					String[]ProcessInfo = pecaInfo1.split(";");
					String[]PlacaVideo	= pecaInfo2.split(";");
					String[]FonteInfo = pecaInfo3.split(";");
					
					//Especificações do Processador
					int geracaoPro = Integer.parseInt(ProcessInfo[0]);
					
					String socketPro = ProcessInfo[1];
					String RAMPro = ProcessInfo[2];
					
					int tamMaxRam = Integer.parseInt(ProcessInfo[3]);
					int TDPPro = Integer.parseInt(ProcessInfo[4]);
					
					String GPU = ProcessInfo[5];
					
					int nucleos = Integer.parseInt(ProcessInfo[6]);
					int threads = Integer.parseInt(ProcessInfo[7]);
					double freqBase = Double.parseDouble(ProcessInfo[8]);
					double freqMax = Double.parseDouble(ProcessInfo[9]);
					
					//--------

					
					//Especificações da Fonte
					int potencia = Integer.parseInt(FonteInfo[0]);
					String selo = FonteInfo[1];
					
					//--------
					
					//Especificações da Placa de Video
					int TDPVideo = Integer.parseInt(PlacaVideo[0]);
					double pCLEVideo = Double.parseDouble(PlacaVideo[1]);
					int vRAMV = Integer.parseInt(PlacaVideo[2]);
					
					String tecRAMV = PlacaVideo[3];
					
					int baseClockV = Integer.parseInt(PlacaVideo[4]);						
					int boostClockV = Integer.parseInt(PlacaVideo[5]);						
					int memoryClockV = Integer.parseInt(PlacaVideo[6]);						
					int qtdCoresV = Integer.parseInt(PlacaVideo[7]);
					
					//------------------------------
					
					//Verificando compatibilidade de acordo com a quantidade de Potencia
					
					double resultado = (TDPPro + TDPVideo)*1.25;
					
					if(potencia >= resultado){
						
						System.out.println("A Fonte " + Nome3 + " é compativel com as Pecas escolhidas"); 
						System.out.println("Isto porque, a soma entre a potencia do processador e da placa de vídeo, multiplado por 1,10 á 1,25 é MENOR ou IGUAL a potencia da Fonte, confira: "); 
						
						System.out.println("---\nFonte: " + Nome3 + " - Potencia : " + potencia); 
						System.out.println("Processador: " + Nome1 + " - Potencia : " + TDPPro); 
						System.out.println("Placa de Video: " + Nome2 + " - Potencia : " + TDPVideo); 
						System.out.println("Potencia do PC: " + resultado); 
					}
					else{
						
						System.out.println("A Fonte " + Nome3 + " NAO é compativel com as Pecas escolhidas"); 
						System.out.println("Isto porque, a soma entre a potencia do processador e da placa de vídeo, multiplado por 1,10 á 1,25 é MAIOR que a potencia da Fonte, confira:"); 
						
						System.out.println("---\nFonte: " + Nome3 + " - Potencia : " + potencia); 
						System.out.println("Processador: " + Nome1 + " - Potencia : " + TDPPro); 
						System.out.println("Placa de Video: " + Nome2 + " - Potencia : " + TDPVideo); 
						System.out.println("Potencia do PC: " + resultado); 
					}	
				
				}
			
			}
}
