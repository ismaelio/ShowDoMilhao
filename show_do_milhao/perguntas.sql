-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: 01-Dez-2019 às 23:55
-- Versão do servidor: 5.7.21
-- PHP Version: 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `perguntas`
--
CREATE DATABASE IF NOT EXISTS `perguntas` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `perguntas`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `dificil`
--

DROP TABLE IF EXISTS `dificil`;
CREATE TABLE IF NOT EXISTS `dificil` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `pergunta` varchar(255) NOT NULL,
  `resp1` varchar(10000) NOT NULL,
  `resp2` varchar(10000) NOT NULL,
  `resp3` varchar(10000) NOT NULL,
  `resp4` varchar(10000) NOT NULL,
  `cor` int(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `dificil`
--

INSERT INTO `dificil` (`id`, `pergunta`, `resp1`, `resp2`, `resp3`, `resp4`, `cor`) VALUES
(1, 'Em que dia nasceu o ex-presidente Lula?', '6 de outubro', '8 de outubro', '27 de outubro', '29 de outubro', 3),
(2, 'Qual desses filmes não foi dirigido por Steven Spielberg?', 'A Lista de Schindler', 'A Cor Púrpura', 'Império do Sol', 'O Exterminador do Futuro', 4),
(3, 'A frase \"Os fins justificam os meios\" é atribuída a quem?', 'Aristóteles', 'Thomas Hobbes', 'Immanuel Kant', 'Maquiavel', 4),
(4, 'Em que país está localizada a cidade de Chernobyl?', 'Rússia', 'Ucrânia', 'Romênia', 'Estados Unidos', 2),
(5, 'Onde nasceu Bill Clinton?', 'Los Angeles', 'Chicago', 'Hope', 'Dallas', 3),
(6, 'A frase \"Temos de nos tornar a mudança que queremos ver\" é atribuída a quem?', 'Mahatma Gandhi', 'Friedrich Nietzsche', 'Leonardo da Vinci', 'Nelson Mandela', 1),
(7, 'Em qual espécie o macho choca\nos ovos e a fêmea procura\nalimento?', 'Andorinha', 'Pato selvagem', 'Pinguim', 'Marreco', 3),
(8, 'Onde nasceu Van Gogh, o\ngrande pintor impressionista?', 'Polônia', 'França', 'Itália', 'Holanda', 4),
(9, 'Qual é a décima terceira letra do\nalfabeto grego?', 'Alfa', 'Delta', 'Ni', 'Csi', 3),
(10, 'Que conflito ideológico\nenvolveu os EUA e a União\nSoviética?', 'Guerra Fria', 'Guerra do Golfo', 'Guerra Quente', 'Guerra do Japão', 1),
(11, 'O trapézio é um músculo situado\nem que parte do corpo?', 'Pescoço', 'Ombro', 'Cabeça', 'Braço', 2),
(12, 'Qual o símbolo químico do\nchumbo?', 'Pb', 'Ch', 'Co', 'Dg', 1),
(13, 'Qual a ciência que estuda a\ndistribuição dos animais?', 'Zooterapia', 'Zoogeografia', 'Zodíaco', 'Zoometria', 2),
(14, 'A eletrônica é parte de qual\nciência?', 'Física', 'Biologia', 'Matemática', 'Alquimia', 1),
(15, 'Que símbolo está desenhado\nno centro da bandeira\nArgentina?', 'Sol', 'Lua', 'Estrela', 'Foice e Martelo', 1),
(16, 'A quem se atribui a frase “Eu\nsou o Estado”?', 'Napoleão Bonaparte', 'Luís XIII', 'Luís XIV', 'Luís XV', 3),
(17, 'O que significa defenestrar?', 'Atirar algo por uma janela', 'Lanchar', 'Desfazer uma amizade', 'Rasgar uma folha de papel', 1),
(18, 'Que significa o prefixo exo?', 'Dentro de', 'Debaixo de', 'Fora de', 'Atrás de', 3),
(19, 'Que trópico atravessa o\nSaara?', 'Capricórnio', 'Virgem', 'Câncer', 'Leão', 3),
(20, 'Quem foi aluno de Platão e\ntutor de Alexandre, o\nGrande?', 'Pitágoras', 'Diderot', 'Aristóteles', 'Galileu Galilei', 3),
(21, '“Guernica” é uma tela de qual\npintor?', 'Leonardo da Vinci', 'Monet', 'Picasso', 'Renoir', 3),
(22, 'A que letra do nosso alfabeto\ncorresponde a letra grega\ntau?', 'F', 'H', 'J', 'T', 4),
(23, 'Qual é a especialidade dos\nprofissionais que analisam os\nsulcos e marcas de uma bala?', 'Baleagem', 'Balística', 'Logística', 'Impressão digital', 2),
(24, 'Qual metal possui o símbolo\nHg?', 'Ferro', 'Aço', 'Mercúrio', 'Ouro', 3),
(25, 'Qual é o nome dado a um\nconjunto de sinos?', 'Corrimão', 'Carrilhão', 'Badalada', 'Corselete', 2),
(26, 'Quem escreveu “Dom\nQuixote”?', 'Espinoza', 'Miguel de Cervantes', 'Carlos Conte', 'Angel Morita', 2),
(27, 'O que é glicose?', 'Aminoácido', 'Carboidrato', 'Lipídio', 'Proteína', 2),
(28, 'A onirologia é o estudo de que?', 'Patos', 'Vulcões', 'Nariz', 'Sonhos', 4),
(29, 'Como morreu Kurt Cobain?', 'Suicídio', 'Velhice', 'Aids', 'Acidente de carro', 1),
(30, 'Qual é o significado da frase\ninglesa “I am still here”?', 'Eu ainda estou aqui', 'Te vejo depois', 'Eu tenho que ir', 'Tenha cuidado', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `expert`
--

DROP TABLE IF EXISTS `expert`;
CREATE TABLE IF NOT EXISTS `expert` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `pergunta` varchar(255) NOT NULL,
  `resp1` varchar(10000) NOT NULL,
  `resp2` varchar(10000) NOT NULL,
  `resp3` varchar(10000) NOT NULL,
  `resp4` varchar(10000) NOT NULL,
  `cor` int(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `expert`
--

INSERT INTO `expert` (`id`, `pergunta`, `resp1`, `resp2`, `resp3`, `resp4`, `cor`) VALUES
(1, 'O que significa Ailurofobia?', 'Medo do escuro', 'Medo de cães', 'Medo de multidões', 'Medo de gatos', 4),
(2, 'Qual destes livros não foi escrito por\nStephen King?', 'Os Olhos do Dragão', 'À Espera de um Milagre', 'A Metade Negra', 'A Casa Infernal', 4),
(3, 'Na obra de Dante, o inferno é formado\npor quantos círculos?', '7', '8', '9', '10', 3),
(4, 'Qual destes filmes não foi dirigido por\nTim Burton?', 'Edward Mãos de Tesoura', 'O Estranho Mundo de Jack', 'A Noiva-Cadáver', 'Os Fantasmas se Divertem', 2),
(5, 'Em que ano foi lançado o videogame\nAtari 2600 na América do Norte?', '1975', '1977', '1978', '1981', 2),
(6, 'Qual o endereço fictício de\nSherlock Holmes?', '221B Baker Street', '97A Baker Street', '36A Piccadilly', '215B Piccadilly', 1),
(7, 'O que significa a expressão em latim\n\"Carpe noctem\"?', 'Culpa feliz', 'Aproveite o dia', 'Aproveite a noite', 'Aproveite a vida', 3),
(8, 'Qual desses filmes não foi dirigido por \nJorge furtado?', 'O Homem que Copiava', 'Meu Tio Matou um Cara', 'Rummikub', 'Tropa de elite', 4),
(9, 'Qual o nome da guitarra usada \npelo Slash?', 'Ibanez', 'Gibson Les Paul', 'Strinberg', 'Fender', 2),
(10, 'Alan Turing é conhecido como o que?', 'Pai da computação', 'Pai da aviação', 'Pai dos ricos', 'Pai da biologia', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `facil`
--

DROP TABLE IF EXISTS `facil`;
CREATE TABLE IF NOT EXISTS `facil` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `pergunta` varchar(255) NOT NULL,
  `resp1` varchar(10000) NOT NULL,
  `resp2` varchar(10000) NOT NULL,
  `resp3` varchar(10000) NOT NULL,
  `resp4` varchar(10000) NOT NULL,
  `cor` int(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `facil`
--

INSERT INTO `facil` (`id`, `pergunta`, `resp1`, `resp2`, `resp3`, `resp4`, `cor`) VALUES
(1, 'De quantos anos é constituído\r\num século?', '10', '50', '100', '1000', 3),
(2, 'Qual é o naipe do baralho que\r\ntem o desenho de coração?', 'Ouros', 'Espadas', 'Copas', 'Paus', 3),
(3, 'Em qual cidade está o Cristo\r\nRedentor do Corcovado?', 'São Paulo', 'Rio de Janeiro', 'Curitiba', 'Belo Horizonte', 2),
(4, 'Quantos centímetros equivalem\r\na um metro?', '10', '100', '1000', '10000', 2),
(5, 'No julgamento de Jesus, quem\r\ndisse a frase: “Eu lavo minhas\r\nmãos”?', 'Barrabás', 'Tibério', 'Pôncio Pilatos', 'Judas', 3),
(6, 'Quantos eram os anões da\r\nhistória “A branca de neve”?', '3', '4', '6', '7', 4),
(7, 'Quantas cores compõem o\r\narco-íris?', '7', '14', '21', '49', 1),
(8, 'O que é Via Láctea?', 'Marca de leite', 'Civilização antiga', 'Marca de carro', 'Galáxia', 4),
(9, 'Qual é o nome dado ao estado\nda água em forma de gelo?', 'Líquido', 'Sólido', 'Gasoso', 'Vaporoso', 2),
(10, 'Qual é o signo do zodíaco de\nquem nasce no dia do ano-novo?', 'Virgem', 'Aquário', 'Capricórnio', 'Áries', 3),
(11, 'A água ferve a quantos graus\ncentígrados?', '100', '232', '170', '157', 1),
(12, 'Como se chama o lugar onde\nsão armazenadas as balas de\num revólver?', 'Cano', 'Tambor', 'Agulha', 'Gatilho', 2),
(13, 'Qual personagem da turma da\nMônica tem apenas cinco fios\nde cabelo?', 'Mônico', 'Cebolinha', 'Cascão', 'Magali', 2),
(14, 'Qual é a pedra preciosa mais\ndura encontrada na natureza?', 'Esmeralda', 'Rubi', 'Pérola', 'Diamante', 4),
(15, 'Qual cantor ficou conhecido\ncomo “o rei do rock”?', 'Frank Sinatra', 'Little Richard', 'Elvis Presley', 'Richie Valens', 3),
(16, 'Quantos dias tem um ano\nbissexto?', '364', '365', '366', '367', 3),
(17, 'Qual é o réptil que muda de cor\nconforme o lugar em que está?', 'Sapo', 'Camaleão', 'Lagarto', 'Jacaré', 2),
(18, 'Qual era o código da identidade\nsecreta de James Bond?', '157', '907', '008', '007', 4),
(19, 'Em que ano os portugueses\ndescobriram o Brasil?', '1450', '1500', '1550', '1600', 2),
(20, 'O que é medido por um\ntermômetro?', 'Longitude', 'Umidade', 'Temperatura', 'Latitude', 3),
(21, 'Qual é a moeda oficial dos\nEstados Unidos?', 'Dólar', 'Escudo', 'Coroa', 'Libra', 1),
(22, 'Quantas folhas tem um trevo\nda sorte?', 'Três', 'Quatro', 'Cinco', 'Seis', 2),
(23, 'Qual ator do cinema brasileiro é\nconhecido por ter unhas\nenormes?', 'Penadinho', 'Zé do casarão', 'Toninho do diabo', 'Zé do caixão', 4),
(24, 'O violoncelo é um tipo de\ninstrumento de?', 'Sopro', 'Cordas', 'Percussão', 'Repercussão', 2),
(25, 'Cavalo, rainha e torre são\npeças de qual jogo?', 'Damas', 'Xadrez', 'Ludo', 'Dominó', 2),
(26, 'Segundo a Bíblia, quem foi\nmorto por Caim?', 'Adão', 'Isaac', 'Abraão', 'Abel', 4),
(27, 'Qual ser mitológico possui o\ncorpo metade mulher e metade\npeixe?', 'Sereia', 'Medusa', 'Cleópatra', 'Serena', 1),
(28, 'Qual foi o nome dado ao\nmovimento liderado por\nTiradentes?', 'Revolução francesa', 'Guerra dos Emboabas', 'Inconfidência Mineira', 'Segunda Guerra Mundial', 3),
(29, 'Qual destes elementos se\nforma dentro das ostras?', 'Diamante', 'Pérola', 'Rubi', 'Esmeralda', 2),
(30, 'Qual é o animal que puxa o\ntrenó do Papai Noel?', 'Cavalo', 'Touro', 'Rena', 'Jumento', 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `medio`
--

DROP TABLE IF EXISTS `medio`;
CREATE TABLE IF NOT EXISTS `medio` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `pergunta` varchar(255) NOT NULL,
  `resp1` varchar(10000) NOT NULL,
  `resp2` varchar(10000) NOT NULL,
  `resp3` varchar(10000) NOT NULL,
  `resp4` varchar(10000) NOT NULL,
  `cor` int(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `medio`
--

INSERT INTO `medio` (`id`, `pergunta`, `resp1`, `resp2`, `resp3`, `resp4`, `cor`) VALUES
(1, 'Qual é a capital da Austrália?', 'Sidney', 'Camberra', 'Darwin', 'Melbourne', 2),
(2, 'Qual a área que cuida da saúde bucal?', 'Ortopedia', 'Cardiologia', 'Odontologia', 'Hematologia', 3),
(3, 'Qual é o nome completo do cantor Tim Maia?', 'Sebastião Rodrigues Maia', 'Timóteo Rodrigues Maia', 'Timóteo Carlos da Costa', 'Sebastião Carlos Maia', 1),
(4, 'Que profissional usa uma ferramenta chamada formão?', 'Carpinteiro', 'Relojoeiro', 'Confeiteiro', 'Bombeiro', 1),
(5, 'O que significa \"ósculo\"?', 'Abraço', 'Óculos', 'Mesa', 'Beijo', 4),
(6, 'De que origem é o fósforo?', 'Artificial', 'Mineral', 'Vegetal', 'Animal', 2),
(7, 'Que imperador é acusado de ter posto fogo \nem Roma?', 'Trajano', 'Nero', 'Brutus', 'Calígula', 2),
(8, 'O alpinismo é praticado em que\nlugar?', 'Mar', 'Rio', 'Montanha', 'Praia', 3),
(9, 'O Coliseu é um monumento\nhistórico de que cidade\neuropéia?', 'Paris', 'Milão', 'Roma', 'Londres', 3),
(10, 'Que rio corta a cidade de\nLondres, na Inglaterra?', 'Tâmisa', 'Sena', 'Reno', 'Aube', 1),
(11, 'Quem foi eleito presidente da\nÁfrica do Sul em 1994?', 'Nelson Piquet', 'Nelson Mandela', 'Nelson Ned', 'John Nelson', 2),
(12, 'Segundo a crença popular, a\nmula-sem-cabeça é mulher de\nquem?', 'Do Coronha', 'Do Padre', 'Do Sacristão', 'Do Bispo', 2),
(13, 'Que atriz protagonizou o filme\n“Titanic”?', 'Cameron Diaz', 'Kate Winslet', 'Bridget Fonda', 'Catherine Zetta Jones', 2),
(14, 'Como é chamada a doença que\ncausa perda desigual da\nmelanina?', 'Astigmatismo', 'Tendinite', 'Vitiligo', 'Vitinga', 3),
(15, 'No filme, quem era parceiro de\ncrimes da Bonnie?', 'Bill', 'Clyde', 'James', 'Butch', 2),
(16, 'Quem é o parceiro de\naventuras de Dom Quixote?', 'Sancho Pança', 'Guilherme Tell', 'Sigmund Freud', 'Lancelot', 1),
(17, 'Que planta era usada para\nfabricação de papel no antigo\nEgito?', 'Papiro', 'Eucalipto', 'Oliveira', 'Milho', 1),
(18, 'O que os filatelistas\ncolecionam?', 'Quadros', 'Moedas', 'Selos', 'Figurinhas', 3),
(19, 'Quando começou e terminou a\nPrimeira Guerra Mundial?', '1914-1918', '1939-1945', '1921-1932', '1912-1915', 1),
(20, 'Qual é a letra do alfabeto que\nsimboliza o número dez em\nalgarismo romano?', 'V', 'D', 'L', 'X', 4),
(21, 'Em que matéria estuda-se\nálgebra na escola?', 'Matemática', 'Biologia', 'Química', 'Física', 1),
(22, 'Qual é o nome original do filme\n“O médico e o monstro”?', 'Masters e Johnson', 'Dr. Jekyll e Mr. Hyde', 'Bonnie e Clyde', 'Dom Quixote', 2),
(23, 'Quem disse a frase: “Vim, vi e\nvenci”?', 'Júlio César', 'Calígula', 'Nero', 'Marco Antônio', 1),
(24, 'Em que estado norte-americano\nfica a cidade de Miami?', 'Alasca', 'Nova Iorque', 'Flórida', 'Califórnia', 3),
(25, 'Em que ano morreu Freddie Mercury?', '1989', '1990', '1991', '1992', 3),
(26, 'Qual é o nome do cachorro de\nCharlie Brown?', 'Alexandre', 'Floquinho', 'Baleia', 'Snoopy', 4),
(27, 'O FBI é a polícia federal de qual\npaís?', 'Inglaterra', 'Estados Unidos', 'Canáda', 'França', 2),
(28, 'Qual dessas cobras não é\nvenenosa?', 'Urutu', 'Cascavel', 'Jararaca', 'Píton', 4),
(29, 'Teresina é a capital de qual\nestado brasileiro?', 'Tocantins', 'Piauí', 'Acre', 'Paraná', 2),
(30, 'O daltônico é deficiente em?', 'Sentir dor', 'Sentir calor', 'Diferenciar cores', 'Sentir cheiro', 3);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
