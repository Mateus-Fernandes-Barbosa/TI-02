let placa_mae = [
  {
    Nome: "ASUS Prime A320M-K",
    Tipo: "estudo",
    Descricao:
      "A ASUS Prime A320M-K é uma placa-mãe compacta e acessível. Baseada no chipset A320, ela oferece suporte a processadores AMD Ryzen de primeira, segunda e terceira geração. Possui recursos básicos necessários para um sistema funcional, como conectividade USB e slots de expansão.",
  },
  {
    Nome: "MSI B350 GAMING PLUS",
    Tipo: "trabalho",
    Descricao:
      "A placa-mãe MSI B350 GAMING PLUS é baseada no chipset B350 e oferece suporte aos processadores AMD Ryzen de primeira, segunda e terceira geração. Com recursos voltados para trabalhos pesados, como suporte a overclocking e conectividade avançada, ela fornece uma plataforma sólida para construir seu sistema.",
  },
  {
    Nome: "ASUS ROG Strix B450-F Gaming",
    Tipo: "lazer_jogos",
    Descricao: "Esta placa-mãe é baseada no chipset B450 e oferece suporte aos processadores AMD Ryzen de segunda e terceira geração. Ela possui recursos voltados para jogos, como suporte a overclocking, iluminação RGB personalizável e conectividade avançada.",
  },
  {
    Nome: "ASUS ROG Crosshair VIII Hero",
    Tipo: "entusiasta",
    Descricao: "A ASUS ROG Crosshair VIII Hero é uma placa-mãe de alta qualidade e desempenho. Baseada no chipset X570, ela oferece suporte aos processadores AMD Ryzen de terceira geração, incluindo o Ryzen 9 5900X. Com recursos avançados, como suporte a overclocking extremo, conectividade de alta velocidade e componentes de qualidade, essa placa-mãe é projetada para entusiastas exigentes.",
  },
];

//------------------------------------------------------------------------------------------------//
let processador = [
  {
    Nome: "MD Athlon 3000G",
    Tipo: "estudo",
    Descricao:
      "O AMD Athlon 3000G é um processador dual-core com suporte a multithreading, oferecendo desempenho adequado para tarefas diárias básicas. Com uma frequência base de 3,5 GHz, ele fornece um bom equilíbrio entre desempenho e preço acessível.",
  },
  {
    Nome: "AMD Ryzen 5 3400G",
    Tipo: "trabalho",
    Descricao:
      "O AMD Ryzen 5 3400G é um processador quad-core com suporte a multithreading. Com uma frequência base de 3,7 GHz e capacidade de overclock, ele oferece um ótimo desempenho para construção de projetos e tarefas multitarefa. Além disso, esse processador inclui uma GPU integrada Radeon Vega 11, dando a possibilidade de execução de softwares gráficos como AUTOCAD e PHOTOSHOP",
  },
  {
    Nome: "AMD Ryzen 5 3600",
    Tipo: "lazer_jogos",
    Descricao: "Este processador de seis núcleos e doze threads da AMD oferece excelente desempenho para jogos e tarefas multitarefa. Ele opera em uma frequência base de 3,6 GHz, com a capacidade de aumentar para 4,2 GHz em modo turbo.",
  },
  {
    Nome: "AMD Ryzen 9 5900X",
    Tipo: "entusiasta",
    Descricao: "O AMD Ryzen 9 5900X é um processador de alto desempenho com 12 núcleos e 24 threads. Com uma frequência base de 3,7 GHz e capacidade de aumentar para 4,8 GHz em modo turbo, ele oferece uma potência impressionante para jogos, criação de conteúdo e tarefas pesadas de multitarefa.",
  },
];

//------------------------------------------------------------------------------------------------//
let placa_de_video = [
  {
    Nome: "NVIDIA GeForce GT 1030",
    Tipo: "estudo",
    Descricao:
      "A NVIDIA GeForce GT 1030 é uma placa de vídeo de entrada que oferece suporte a trabalhos simples e aplicações gráficas básicas. Embora não seja indicada para jogos, ela pode lidar com softwares mais antigos ou menos exigentes em configurações de qualidade reduzida como photoshop e CorelDraw por exemplo.",
  },
  {
    Nome: "NVIDIA GeForce GTX 1650 Super",
    Tipo: "trabalho",
    Descricao:
      "A NVIDIA GeForce GTX 1650 Super é uma placa de vídeo de médio alcance, oferecendo um ótimo desempenho em softwares gráficos em 1080p. Com 4GB de memória GDDR6 e uma arquitetura eficiente, ela é capaz de executar programas como editores de vídeo em configurações médias a altas, proporcionando uma experiência de uso suave e imersiva.",
  },
  {
    Nome: "GTX 1660 Super",
    Tipo: "lazer_jogos",
    Descricao: "A GTX 1660 Super é uma placa de vídeo da NVIDIA que oferece um bom equilíbrio entre desempenho e preço. Ela é capaz de rodar jogos em 1080p com ótimas taxas de quadros e também suporta recursos como Ray Tracing em tempo real.",
  },
  {
    Nome: "NVIDIA GeForce RTX 3080",
    Tipo: "entusiasta",
    Descricao: "A NVIDIA GeForce RTX 3080 é uma das placas de vídeo mais poderosas disponíveis no mercado. Com 10GB de memória GDDR6X, arquitetura Ampere e recursos como Ray Tracing em tempo real e DLSS, ela oferece um desempenho incrível para jogos em 4K e resoluções mais altas, proporcionando gráficos incrivelmente detalhados e taxas de quadros elevadas.",
  },
];

//------------------------------------------------------------------------------------------------//
let memoria_ram = [
  {
    Nome: "Kingston HyperX Fury 4GB DDR4 2666MHz",
    Tipo: "estudo",
    Descricao:
      "Este módulo de memória RAM da Kingston oferece 4GB de capacidade, com uma frequência de 2666MHz. Embora seja uma quantidade mínima recomendada para sistemas modernos, ela ainda permite a execução de tarefas básicas e softwares voltados para estudo.",
  },
  {
    Nome: "Kingston HyperX Fury 8GB DDR4 3200MHz",
    Tipo: "trabalho",
    Descricao:
      "Este módulo de memória RAM da Kingston oferece 8GB de capacidade (2x4) com uma frequência de 3200MHz. Com velocidades mais rápidas, ele garante uma resposta ágil do sistema e suporte adequado para os softwares multitarefas mais recentes, permitindo a execução de várias tarefas simultaneamente.",
  },
  {
    Nome: "Corsair Vengeance 16GB (2x8)",
    Tipo: "lazer_jogos",
    Descricao: "Este kit de memória RAM oferece 16GB de capacidade total, divididos em dois módulos de 8GB. A frequência de 3200MHz garante uma resposta rápida do sistema e suporte adequado para os jogos mais recentes.",
  },
  {
    Nome: "Corsair Dominator Platinum RGB 64GB (4x16)",
    Tipo: "entusiasta",
    Descricao: "Este kit de memória RAM Corsair Dominator Platinum RGB oferece uma capacidade impressionante de 64GB. Com frequência de 3200MHz, latências baixas e um design elegante com iluminação RGB personalizável, essa memória oferece desempenho excepcional e estilo para o seu sistema.",
  },
];

//------------------------------------------------------------------------------------------------//
let hdd_ssd = [
  {
    Nome: "Western Digital Blue 1TB",
    Tipo: "estudo",
    Descricao:
      "O Western Digital Blue é um disco rígido tradicional de 1TB de capacidade. Ele fornece armazenamento espaçoso para seus arquivos e aplicativos, embora não ofereça a velocidade de um SSD. É uma opção confiável para armazenamento em massa.",
  },
  {
    Nome: "Seagate Barracuda 1TB",
    Tipo: "trabalho",
    Descricao:
      "O Seagate Barracuda é um disco rígido tradicional de 1TB de capacidade, fornecendo um amplo espaço de armazenamento para seus arquivos, jogos e aplicativos. Embora não seja tão rápido quanto um SSD, é uma opção confiável para armazenamento em massa.",
  },
  {
    Nome: "SSD NVMe PCIe M.2 500GB",
    Tipo: "lazer_jogos",
    Descricao: "Este SSD NVMe PCIe M.2 da Kingston oferece 500GB de armazenamento rápido e confiável. Ele utiliza a interface PCIe para proporcionar velocidades de leitura e gravação muito superiores às dos discos rígidos tradicionais.",
  },
  {
    Nome: "WD Black SN850 NVMe M.2",
    Tipo: "entusiasta",
    Descricao: "O WD Black SN850 é um SSD NVMe M.2 de alta velocidade com capacidade de armazenamento de 2TB. Com velocidades de leitura e gravação ultrarrápidas, ele oferece tempos de carregamento rápidos para jogos, transferências de arquivos rápidas e resposta ágil do sistema em geral.",
  },
];

//------------------------------------------------------------------------------------------------//
let fonte = [
  {
    Nome: "Corsair CX450",
    Tipo: "estudo",
    Descricao:
      "A Corsair CX450 é uma fonte de alimentação com 450W de potência. Possui certificação 80 Plus Bronze, o que significa que oferece uma eficiência energética adequada. É uma escolha confiável e acessível para sistemas de baixo consumo de energia.",
  },
  {
    Nome: "EVGA 500 BQ",
    Tipo: "trabalho",
    Descricao:
      "A fonte de alimentação EVGA 500 BQ possui 500W de potência com certificação 80 Plus Bronze, garantindo uma eficiência energética adequada. Com cabos modulares para facilitar a organização do gabinete e proteção contra sobretensão, ela fornece energia estável e confiável para o seu sistema.",
  },
  {
    Nome: "Corsair CX550M ",
    Tipo: "lazer_jogos",
    Descricao: "Essa fonte de alimentação da Corsair possui 550W de potência, oferecendo energia estável e confiável para todos os componentes. Sua certificação 80 Plus Bronze garante uma eficiência energética adequada, enquanto o design modular facilita a organização dos cabos e o fluxo de ar dentro do gabinete.",
  },
  {
    Nome: "EVGA SuperNOVA 850W G5 ",
    Tipo: "entusiasta",
    Descricao: "A fonte de alimentação EVGA SuperNOVA 850 G5 possui 850W de potência com certificação 80 Plus Gold, garantindo uma eficiência energética elevada. Com cabos totalmente modulares para facilitar a instalação e gerenciamento de cabos, essa fonte de alimentação fornece energia estável e confiável para todos os componentes de alto desempenho.",
  },
];
