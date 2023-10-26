package service;

import model.Peca;

public class PecaComp extends Peca{

	public PecaComp() {
        super();
    }

	
	//--|CLASSE PARA COMPARAR Pecas, IDENTIFICANDO QUAL A MELHOR DE ACORDO COM AS INFO.Especificas|--
		public void Comparacao(Peca []pecaComparar, int x, int y){
			
			//---|VERIFICANDO A CATEGORIA DE CADA COMPONENTE PARA SER COMPARADO|---
			
			//Comparação de Processadores
			if(pecaComparar[x].getCategoria().equals("Processador") && pecaComparar[y].getCategoria().equals("Processador")){
				
				//Seperando a Informação Especifica
				String[]infoEspecificasX = pecaComparar[x].getInfo_especifica().split(";");
				String[]infoEspecificasY = pecaComparar[y].getInfo_especifica().split(";");
				
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
					
					System.out.println(pecaComparar[x].getNome_componente() + " É um processador melhor que " + pecaComparar[y].getNome_componente()); 
					System.out.println("Isto devido á suas frequencias basicas: "); 
					
					System.out.println(pecaComparar[x].getNome_componente() + " : " + freqBaseX); 
					System.out.println(pecaComparar[y].getNome_componente() + " : " + freqBaseY); 
					
					//AVISAR SER CASO O OVERCLOCK FOR MELHOR QUE O OUTRO PROCESSADOR
					if(freqMaxX < freqMaxY){
						
						System.out.println("Porem, o processador " + pecaComparar[y].getNome_componente() + " possui um overclock melhor que o " + pecaComparar[x].getNome_componente()); 
						System.out.println("Isto devido á suas frequencias maximas(overclock): "); 
						
						System.out.println(pecaComparar[x].getNome_componente() + " : " + freqMaxX); 
						System.out.println(pecaComparar[y].getNome_componente() + " : " + freqMaxY); 
					}
				}
				
				
				//Se Processador Y possuir frequencia maior que Processador X
				else if(freqBaseX < freqBaseY){
					
					System.out.println(pecaComparar[y].getNome_componente() + " É um processador melhor que " + pecaComparar[x].getNome_componente()); 
					System.out.println("Isto devido á suas frequencias basicas: "); 
					
					System.out.println(pecaComparar[x].getNome_componente() + " : " + freqBaseX); 
					System.out.println(pecaComparar[y].getNome_componente() + " : " + freqBaseY); 
					
					//AVISAR SER CASO O OVERCLOCK FOR MELHOR QUE O OUTRO PROCESSADOR
					if(freqMaxX > freqMaxY){
						
						System.out.println("Porem, o processador " + pecaComparar[x].getNome_componente() + " possui um overclock melhor que o " + pecaComparar[y].getNome_componente()); 
						System.out.println("Isto devido á suas frequencias maximas(overclock): "); 
						
						System.out.println(pecaComparar[x].getNome_componente() + " : " + freqMaxX); 
						System.out.println(pecaComparar[y].getNome_componente() + " : " + freqMaxY); 
					}
				}
				
				
				//--|CASO A FREQUENCIA DE AMBOS SEJA IGUAIS, SERÁ COMPARADO A QUANTIDADE DE NUCLEOS|--
				else if(freqBaseX == freqBaseY){
					
					
					//Se Processador X possuir mais nucleos que Processador Y 
					if(nucleosX > nucleosY){
						
						System.out.println(pecaComparar[x].getNome_componente() + " É um processador melhor que " + pecaComparar[y].getNome_componente()); 
						System.out.println("Isto devido a quantidade de nucleos: "); 
						
						System.out.println(pecaComparar[x].getNome_componente() + " : " + nucleosX); 
						System.out.println(pecaComparar[y].getNome_componente() + " : " + nucleosY); 
						
						
						//AVISAR SER CASO O OUTRO PROCESSADOR POSSUIR MAIS THREADS
						if(threadsX < threadsY){
						
							System.out.println("Porem, o processador " + pecaComparar[y].getNome_componente() + " possui mais threads que o " + pecaComparar[x].getNome_componente()); 
							
							System.out.println(pecaComparar[x].getNome_componente() + " : " + threadsX); 
							System.out.println(pecaComparar[y].getNome_componente() + " : " + threadsY); 
						}
						
					}
					
					//Se Processador Y possuir mais nucleos que Processador X
					else if(nucleosX < nucleosY){
						
						System.out.println(pecaComparar[y].getNome_componente() + " É um processador melhor que " + pecaComparar[x].getNome_componente()); 
						System.out.println("Isto devido a sua quantidade de nucleos: "); 
						
						System.out.println(pecaComparar[x].getNome_componente() + " : " + freqBaseX); 
						System.out.println(pecaComparar[y].getNome_componente() + " : " + freqBaseY); 
						
						
						//AVISAR SER CASO O OUTRO PROCESSADOR POSSUIR MAIS THREADS
						if(threadsX > threadsY){
							
							System.out.println("Porem, o processador " + pecaComparar[x].getNome_componente() + " possui mais threads que o " + pecaComparar[y].getNome_componente()); 
							System.out.println(pecaComparar[x].getNome_componente() + " : " + threadsX); 
							System.out.println(pecaComparar[y].getNome_componente() + " : " + threadsY); 
						}
						
					}
					
				}
				else{
					
					System.out.println("Ambos os processadores possuem a mesma perfomance."); 
				}
			}
			
			
			//Comparação de Placa de Videos
			else if(pecaComparar[x].getCategoria().equals("Placa de Vídeo") && pecaComparar[y].getCategoria().equals("Placa de Vídeo")){
				
				//Separando a Informação Especifica
				String[]infoEspecificasX = pecaComparar[x].getInfo_especifica().split(";");
				String[]infoEspecificasY = pecaComparar[y].getInfo_especifica().split(";");
				
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
					
					System.out.println("A placa de vídeo " + pecaComparar[x].getNome_componente() + " é mais rapida que a placa de vídeo " + pecaComparar[y].getNome_componente()); 
					System.out.println("Isto devido a quantidade de cores de cada uma: ");  
					
					System.out.println(pecaComparar[x].getNome_componente() + " : " + qtdCoresX); 
					System.out.println(pecaComparar[y].getNome_componente() + " : " + qtdCoresY); 
					
					//Avisar caso a outra placa possua uma frequencia maior.
					if(baseClockX < baseClockY){
						
						System.out.println("Porém, a placa de vídeo " + pecaComparar[y].getNome_componente() + " possui uma frequencia basica maior que a " + pecaComparar[x].getNome_componente()); 
					
						System.out.println(pecaComparar[x].getNome_componente() + " : " + baseClockX); 
						System.out.println(pecaComparar[y].getNome_componente() + " : " + baseClockY); 
					}
				}
				
				else if(qtdCoresX < qtdCoresY){
					
					System.out.println("A placa de vídeo " + pecaComparar[y].getNome_componente() + " é mais rapida que a placa de vídeo " + pecaComparar[x].getNome_componente()); 
					System.out.println("Isto devido a quantidade de cores de cada uma: ");  
					
					System.out.println(pecaComparar[x].getNome_componente() + " : " + qtdCoresX); 
					System.out.println(pecaComparar[y].getNome_componente() + " : " + qtdCoresY); 
					
					//Avisar caso a outra placa possua uma frequencia maior.
					if(baseClockX > baseClockY){
						
						System.out.println("Porém, a placa de vídeo " + pecaComparar[x].getNome_componente() + " possui uma frequencia basica maior que a " + pecaComparar[y].getNome_componente()); 
					
						System.out.println(pecaComparar[x].getNome_componente() + " : " + baseClockX); 
						System.out.println(pecaComparar[y].getNome_componente() + " : " + baseClockY); 
					}
				}
				
				//CASO OS CORES SEJAM IGUAIS, COMPARAR A FREQUENCIA BASICA
				else if(qtdCoresX == qtdCoresY){
					
					if(baseClockX > baseClockY){
						
						System.out.println("A placa de vídeo " + pecaComparar[x].getNome_componente() + " possui uma frequencia Basica maior que a " + pecaComparar[y].getNome_componente()); 
						
						System.out.println(pecaComparar[x].getNome_componente() + " : " + baseClockX); 
						System.out.println(pecaComparar[y].getNome_componente() + " : " + baseClockY); 
					}
					
					else if(baseClockX < baseClockY){
						
						System.out.println("A placa de vídeo " + pecaComparar[y].getNome_componente() + " possui uma frequencia Basica maior que a " + pecaComparar[x].getNome_componente()); 
					
						System.out.println(pecaComparar[x].getNome_componente() + " : " + baseClockX); 
						System.out.println(pecaComparar[y].getNome_componente() + " : " + baseClockY); 
					}
					
					//CASO A FREQ.Basica SEJA IGUAL, COMPARAR A FREQ. Maxima
					else if(baseClockX == baseClockY){
						
						if(boostClockX > boostClockY){
							
							System.out.println("A placa de vídeo " + pecaComparar[x].getNome_componente() + " possui uma frequencia Maxima maior que a " + pecaComparar[y].getNome_componente()); 
					
							System.out.println(pecaComparar[x].getNome_componente() + " : " + boostClockX); 
							System.out.println(pecaComparar[y].getNome_componente() + " : " + boostClockY); 
						}
						
						else if(boostClockX < boostClockY){
							
							System.out.println("A placa de vídeo " + pecaComparar[y].getNome_componente() + " possui uma frequencia Maxima maior que a " + pecaComparar[x].getNome_componente()); 
					
							System.out.println(pecaComparar[x].getNome_componente() + " : " + boostClockX); 
							System.out.println(pecaComparar[y].getNome_componente() + " : " + boostClockY); 
						}
					}
					
					
				}
				
				//---|Caso perfomance seja igual|---
				else{
					
					System.out.println("Ambas Placa de Vídeos possuem a mesma perfomance"); 
				}
				
			}
			
			
			//Comparação de Placa Mães
			else if(pecaComparar[x].getCategoria().equals("Placa Mãe") && pecaComparar[y].getCategoria().equals("Placa Mãe")){
				
				//Separando as especificações
				String[]infoEspecificasX = pecaComparar[x].getInfo_especifica().split(";");
				String[]infoEspecificasY = pecaComparar[y].getInfo_especifica().split(";");
				
				
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
					
					System.out.println("A placa mãe " + pecaComparar[x].getNome_componente() + " possui mais conectadores de memoria RAM que a placa " + pecaComparar[y].getNome_componente()); 
					
					System.out.println(pecaComparar[x].getNome_componente() + " : " + QtdRAMX); 
					System.out.println(pecaComparar[y].getNome_componente() + " : " + QtdRAMY); 
					
				}
				
				else if(QtdRAMX < QtdRAMY){
					
					System.out.println("A placa mãe " + pecaComparar[y].getNome_componente() + " possui mais conectadores de memoria RAM que a placa " + pecaComparar[x].getNome_componente()); 
					
					System.out.println(pecaComparar[x].getNome_componente() + " : " + QtdRAMX); 
					System.out.println(pecaComparar[y].getNome_componente() + " : " + QtdRAMY); 
				}
				
				//CASO A Quantidade de RAM SEJAM IGUAIS, COMPARAR AS ENTRADAS SATAs
				else if(QtdRAMX == QtdRAMY){
					
					if(QtdSATAX > QtdSATAY){
						
						System.out.println("A placa mãe " + pecaComparar[x].getNome_componente() + " possui mais entradas SATAs que a placa " + pecaComparar[y].getNome_componente()); 
					
						System.out.println(pecaComparar[x].getNome_componente() + " : " + QtdSATAX); 
						System.out.println(pecaComparar[y].getNome_componente() + " : " + QtdSATAY); 
					}
					
					else if(QtdSATAX < QtdSATAY){
						
						System.out.println("A placa mãe " + pecaComparar[y].getNome_componente() + " possui mais entradas SATAs que a placa " + pecaComparar[x].getNome_componente()); 
					
						System.out.println(pecaComparar[x].getNome_componente() + " : " + QtdSATAX); 
						System.out.println(pecaComparar[y].getNome_componente() + " : " + QtdSATAY); 
					}
					
					//CASO A Quantidade de ENTRADAS SATAs SEJAM IGUAIS, COMPARAR A AS ENTRADAS M.2
					else if(QtdSATAX == QtdSATAY){
						
						if(QtdM2X > QtdM2Y){
							
							System.out.println("A placa mãe " + pecaComparar[x].getNome_componente() + " possui mais entradas M.2 que a placa " + pecaComparar[y].getNome_componente()); 
					
							System.out.println(pecaComparar[x].getNome_componente() + " : " + QtdM2X); 
							System.out.println(pecaComparar[y].getNome_componente() + " : " + QtdM2Y); 
					}
						
						else if(QtdM2X < QtdM2Y){
							
							System.out.println("A placa mãe " + pecaComparar[y].getNome_componente() + " possui mais entradas M.2 que a placa " + pecaComparar[x].getNome_componente()); 
					
							System.out.println(pecaComparar[x].getNome_componente() + " : " + QtdM2X); 
							System.out.println(pecaComparar[y].getNome_componente() + " : " + QtdM2Y); 
						}
					}	
					
				}
				
				//---|Caso perfomance seja igual|---
				else{
					
					System.out.println("Ambas Placa Mães possuem a mesma especificade (POSSUA ATENÇÃO ESPECIAL RELACIONADAS A COMPATIBILIDADE)"); 
				}
				
			}
			
			
			//Comparação de RAM
			else if(pecaComparar[x].getCategoria().equals("Memória RAM") && pecaComparar[y].getCategoria().equals("Memória RAM")){
				
				//Separando as especificações
				String[]infoEspecificasX = pecaComparar[x].getInfo_especifica().split(";");
				String[]infoEspecificasY = pecaComparar[y].getInfo_especifica().split(";");
				
				
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
					
					System.out.println("A RAM " + pecaComparar[x].getNome_componente() + " possui mais memoria que a RAM " + pecaComparar[y].getNome_componente()); 
					
					System.out.println(pecaComparar[x].getNome_componente() + " : " + tamRamX); 
					System.out.println(pecaComparar[y].getNome_componente() + " : " + tamRamY); 
					
				}
				
				else if(tamRamX < tamRamY){
					
					System.out.println("A RAM " + pecaComparar[y].getNome_componente() + " possui mais memoria que a RAM " + pecaComparar[x].getNome_componente()); 
					
					System.out.println(pecaComparar[x].getNome_componente() + " : " + tamRamX); 
					System.out.println(pecaComparar[y].getNome_componente() + " : " + tamRamY); 
				}
				
				//CASO O TAMANHO DA MEMORIA SEJA IGUAL, COMPARAR O TIPO
				else if(tamRamX == tamRamY){
					
					int resultado = tipoRamX.compareTo(tipoRamY);
					
					if(resultado > 0){
						
						System.out.println("A placa mãe " + pecaComparar[x].getNome_componente() + " possui um tipo de memoria RAM melhor que a " + pecaComparar[y].getNome_componente()); 
					
						System.out.println(pecaComparar[x].getNome_componente() + " : " + tipoRamX); 
						System.out.println(pecaComparar[y].getNome_componente() + " : " + tipoRamY); 
					}
					
					else if(resultado < 0){
						
						System.out.println("A placa mãe " + pecaComparar[y].getNome_componente() + " possui um tipo de memoria RAM melhor que a " + pecaComparar[x].getNome_componente()); 
					
						System.out.println(pecaComparar[x].getNome_componente() + " : " + tipoRamX); 
						System.out.println(pecaComparar[y].getNome_componente() + " : " + tipoRamY); 
					}
				}
				else{
					
					System.out.println("Ambas as memorias rams possuem as mesmas especifidades"); 
				}
				
			}
			
			
			//Comparação de Fonte
			else if(pecaComparar[x].getCategoria().equals("Fontes") && pecaComparar[y].getCategoria().equals("Fontes")){
				
				//Separando as especificações
				String[]infoEspecificasX = pecaComparar[x].getInfo_especifica().split(";");
				String[]infoEspecificasY = pecaComparar[y].getInfo_especifica().split(";");
				
				int potenciaX = Integer.parseInt(infoEspecificasX[0]);
				int potenciaY = Integer.parseInt(infoEspecificasY[0]);
				
				String seloX = infoEspecificasX[1];
				String seloY = infoEspecificasY[1];
				
				//METODO PARA COMPARAR O SELO PLUS DAS FONTES
				int compSeloX;
				int compSeloY;

				if(seloX.equals("Bronze")){ compSeloX = 0; }
				else if(seloX.equals("White")){ compSeloX = 1; }
				else if(seloX.equals("Gold")){ compSeloX = 2;}
				else{ compSeloX = -1;}
				
				if(seloY.equals("Bronze")){ compSeloY = 0; }
				else if(seloY.equals("White")){ compSeloY = 1; }
				else if(seloY.equals("Gold")){ compSeloY = 2;}
				else{ compSeloY = -1;}
				
				
				//COMPARANDO DE ACORDO COM O SELO
				if(compSeloX > compSeloY){
					
					System.out.println("A fonte " + pecaComparar[x].getNome_componente() + " é melhor que a fonte " + pecaComparar[y].getNome_componente()); 
					
					System.out.println(pecaComparar[x].getNome_componente() + " : " + seloX); 
					System.out.println(pecaComparar[y].getNome_componente() + " : " + seloY); 
				}
				else if(compSeloX < compSeloY){
					
					System.out.println("A fonte " + pecaComparar[y].getNome_componente() + " é melhor que a fonte " + pecaComparar[x].getNome_componente()); 
					
					System.out.println(pecaComparar[x].getNome_componente() + " : " + seloX); 
					System.out.println(pecaComparar[y].getNome_componente() + " : " + seloY); 
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
			public void CompatibilidadeProcessadorMotherBoard(Peca peçaCompatibilidade[], int x, int y){
				
				//--|VERIFICANDO QUAL O TIPO DE COMPATIBILIDADE DEVE SER FEITA|--
				
				if(peçaCompatibilidade[x].getCategoria().equals("Processador") && peçaCompatibilidade[y].getCategoria().equals("Placa Mãe")){
					
					//Seperando as informações especificas do Processador e da Placa Mae
					
					String[]ProcessInfo = peçaCompatibilidade[x].getInfo_especifica().split(";");
					String[]MotherBInfo = peçaCompatibilidade[y].getInfo_especifica().split(";");
					
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
					
					if(((geracaoPro == geracao1) || (geracaoPro == geracao2)) && (socketPro.equals(socketMother))){
						
						System.out.println("O processador " + peçaCompatibilidade[x].getNome_componente() + " É compativel com a Placa Mãe " + peçaCompatibilidade[y].getNome_componente()); 
						
						System.out.println(peçaCompatibilidade[x].getNome_componente() + " : " + geracaoPro); 
						System.out.println(peçaCompatibilidade[y].getNome_componente() + " : " + geracao1 + "/" + geracao2 + "\n"); 
						
						System.out.println(peçaCompatibilidade[x].getNome_componente() + " : " + socketPro); 
						System.out.println(peçaCompatibilidade[y].getNome_componente() + " : " + socketMother); 
					}
					else{
						
						System.out.println("O processador " + peçaCompatibilidade[x].getNome_componente() + " NAO é compativel com a Placa Mãe " + peçaCompatibilidade[y].getNome_componente()); 
						
						System.out.println(peçaCompatibilidade[x].getNome_componente() + " : " + geracaoPro); 
						System.out.println(peçaCompatibilidade[y].getNome_componente() + " : " + geracao1 + "/" + geracao2 + "\n"); 
						
						System.out.println(peçaCompatibilidade[x].getNome_componente() + " : " + socketPro); 
						System.out.println(peçaCompatibilidade[y].getNome_componente() + " : " + socketMother); 
						
					}
					
					if(GPUPro.equals("NAO")){
						
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
			
			public void Compatibilidade(Peca peçaCompatibilidade[], int x, int y, int z){
				
				//-------|COMPATIBILIDADE ENTRE PROCESSADOR, PLACA DE VIDEO E PLACA MAE|-------
				if(peçaCompatibilidade[x].getCategoria().equals("Processador") && peçaCompatibilidade[y].getCategoria().equals("Placa de Vídeo") && peçaCompatibilidade[z].getCategoria().equals("Placa Mãe")){
					
					//Separando as informações especificas
					String[]ProcessInfo = peçaCompatibilidade[x].getInfo_especifica().split(";");
					String[]PlacaVideo	= peçaCompatibilidade[y].getInfo_especifica().split(";");
					String[]MotherBInfo	= peçaCompatibilidade[z].getInfo_especifica().split(";");
					
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
						
						System.out.println("A placa de Vídeo " + peçaCompatibilidade[y].getNome_componente() + " é compativel com " + peçaCompatibilidade[z].getNome_componente()); 
						System.out.println("Isto porque a tecnologia da entrada pCLE da placa mae é maior que da placa de vídeo"); 
						System.out.println("----\nPlaca de video : " + peçaCompatibilidade[y].getNome_componente() + " - pCLE : " +  pCLEVideo); 
						System.out.println("Placa Mãe : " + peçaCompatibilidade[z].getNome_componente() + " - pCLE : " +  pCLEMother); 
					}
					else if (pCLEMother == pCLEVideo){
						
						System.out.println("A placa de Vídeo " + peçaCompatibilidade[y].getNome_componente() + " é compativel com " + peçaCompatibilidade[z].getNome_componente()); 
						System.out.println("Isto porque a tecnologia da entrada pCLE da placa mae é igual que da placa de vídeo"); 
						System.out.println("----\nPlaca de video : " + peçaCompatibilidade[y].getNome_componente() + " - pCLE : " +  pCLEVideo); 
						System.out.println("Placa Mãe : " + peçaCompatibilidade[z].getNome_componente() + " - pCLE : " +  pCLEMother); 
						
					}
					else{
						
						System.out.println("A placa de Vídeo " + peçaCompatibilidade[y].getNome_componente() + " é compativel com " + peçaCompatibilidade[z].getNome_componente()); 
						
						System.out.println("POREM, a placa nao será usada 100%"); 
						
						System.out.println("Isto porque a tecnologia da entrada pCLE da placa mae é menor que da placa de vídeo"); 
						System.out.println("----\nPlaca de video : " + peçaCompatibilidade[y].getNome_componente() + " - pCLE : " +  pCLEVideo); 
						System.out.println("Placa Mãe : " + peçaCompatibilidade[z].getNome_componente() + " - pCLE : " +  pCLEMother); 
					
					}
					
				}
				
				
				//-------|COMPATIBILIDADE ENTRE PROCESSADOR, MEMORIA RAM E PLACA MAE|----------
				else if(peçaCompatibilidade[x].getCategoria().equals("Processador") && peçaCompatibilidade[y].getCategoria().equals("Memória RAM") && peçaCompatibilidade[z].getCategoria().equals("Placa Mãe")){
					
					//Separando as informações especificas
					String[]ProcessInfo = peçaCompatibilidade[x].getInfo_especifica().split(";");
					String[]MemRamInfo 	= peçaCompatibilidade[y].getInfo_especifica().split(";");
					String[]MotherBInfo	 = peçaCompatibilidade[z].getInfo_especifica().split(";");
					
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
					
					if(tipoRam.equals(RAMPro) && tipoRam.equals(RAMMother)){
						
						System.out.println("A memoria RAM é compativel com a placa mãe e com o processador"); 
						System.out.println("Isto porque o tipode de RAM é o mesmo dos outros dois componentes"); 
						
						System.out.println("---\nMemoria RAM : " + peçaCompatibilidade[y].getNome_componente() + " - Tipo de RAM : " + tipoRam); 
						System.out.println("Processador : " + peçaCompatibilidade[x].getNome_componente() + " - Tipo de RAM : " + RAMPro); 
						System.out.println("Placa Mae : " + peçaCompatibilidade[z].getNome_componente() + " - Tipo de RAM : " + RAMMother); 
					}
					else{
						
						System.out.println("A memoria RAM NAO é compativel com a placa mãe e com o processador"); 
						System.out.println("Isto porque o tipode de RAM NAO é o mesmo dos outros dois componentes. Confira abaixo"); 
						
						System.out.println("---\nMemoria RAM : " + peçaCompatibilidade[y].getNome_componente() + " - Tipo de RAM : " + tipoRam); 
						System.out.println("Processador : " + peçaCompatibilidade[x].getNome_componente() + " - Tipo de RAM : " + RAMPro); 
						System.out.println("Placa Mae : " + peçaCompatibilidade[z].getNome_componente() + " - Tipo de RAM : " + RAMMother); 
					}
					
				}
				
				
				//-------|COMPATIBILIDADE ENTRE PROCESSADOR, PLACA DE VIDEO E FONTES|-----
				else if(peçaCompatibilidade[x].getCategoria().equals("Processador") && peçaCompatibilidade[y].getCategoria().equals("Placa de Vídeo") && peçaCompatibilidade[z].getCategoria().equals("Fontes")){
				
					//Separando as informações especificas
					String[]ProcessInfo = peçaCompatibilidade[x].getInfo_especifica().split(";");
					String[]PlacaVideo	= peçaCompatibilidade[y].getInfo_especifica().split(";");
					String[]FonteInfo = peçaCompatibilidade[z].getInfo_especifica().split(";");
					
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
						
						System.out.println("A Fonte " + peçaCompatibilidade[z].getNome_componente() + " é compativel com as Pecas escolhidas"); 
						System.out.println("Isto porque, a soma entre a potencia do processador e da placa de vídeo, multiplado por 1,10 á 1,25 é MENOR ou IGUAL a potencia da Fonte, confira: "); 
						
						System.out.println("---\nFonte: " + peçaCompatibilidade[z].getNome_componente() + " - Potencia : " + potencia); 
						System.out.println("Processador: " + peçaCompatibilidade[x].getNome_componente() + " - Potencia : " + TDPPro); 
						System.out.println("Placa de Video: " + peçaCompatibilidade[y].getNome_componente() + " - Potencia : " + TDPVideo); 
						System.out.println("Potencia do PC: " + resultado); 
					}
					else{
						
						System.out.println("A Fonte " + peçaCompatibilidade[z].getNome_componente() + " NAO é compativel com as Pecas escolhidas"); 
						System.out.println("Isto porque, a soma entre a potencia do processador e da placa de vídeo, multiplado por 1,10 á 1,25 é MAIOR que a potencia da Fonte, confira:"); 
						
						System.out.println("---\nFonte: " + peçaCompatibilidade[z].getNome_componente() + " - Potencia : " + potencia); 
						System.out.println("Processador: " + peçaCompatibilidade[x].getNome_componente() + " - Potencia : " + TDPPro); 
						System.out.println("Placa de Video: " + peçaCompatibilidade[y].getNome_componente() + " - Potencia : " + TDPVideo); 
						System.out.println("Potencia do PC: " + resultado); 
					}	
				
				}
			
			}
	
}
