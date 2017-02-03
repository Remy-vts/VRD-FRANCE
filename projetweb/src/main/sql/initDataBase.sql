-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: devweb_projet
-- ------------------------------------------------------
-- Server version	5.7.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article` (
  `id_article` int(11) NOT NULL AUTO_INCREMENT,
  `date_publication` varchar(20) DEFAULT NULL,
  `marque` varchar(15) NOT NULL,
  `prix` decimal(5,2) NOT NULL,
  `site` varchar(45) NOT NULL,
  `photo` varchar(250) NOT NULL,
  `lien` varchar(255) NOT NULL,
  `idcategorie` int(11) NOT NULL,
  `deleted` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id_article`),
  KEY `id_categorie_idx` (`idcategorie`),
  CONSTRAINT `id_categorie_fk` FOREIGN KEY (`idcategorie`) REFERENCES `categorie` (`id_categorie`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (35,'22/12/2016 04:18:01','Palladium',159.99,'Sarenza','C:\\HEI\\data\\boots1.jpg','http://www.sarenza.com/palladium-pampa-sport-wps-s805386-p0000107589',1,'\0'),(40,'22/12/2016 04:38:48','Caterpillar',149.90,'Sarenza','C:\\HEI\\data\\boots2.jpg','http://www.sarenza.com/caterpillar-colorado-s2525-p0000007860',1,'\0'),(42,'22/12/2016 05:04:24','Geox',115.00,'Sarenza','C:\\HEI\\data\\mocassins1.jpg','http://www.sarenza.com/geox-u-giona-b-u640xb-s817542-p0000139292',4,'\0'),(43,'22/12/2016 05:05:46','Minnetonka',100.00,'Sarenza','C:\\HEI\\data\\mocassins2.jpg','http://www.sarenza.com/minnetonka-men-s-casual-moc-s783240-p0000151990',4,'\0'),(44,'22/12/2016 05:06:57','Gola',85.00,'Sarenza','C:\\HEI\\data\\baskets1.jpg','http://www.sarenza.com/gola-equipe-suede-s830875-p0000116233',6,'\0'),(45,'22/12/2016 05:09:57','Marvin&Co',119.00,'Sarenza','C:\\HEI\\data\\richelieu1.jpg','http://www.sarenza.com/marvin-co-norwood-s816680-p0000140314',2,'\0'),(46,'22/12/2016 05:11:32','Clarks',130.00,'Sarenza','C:\\HEI\\data\\desert1.jpg','http://www.sarenza.com/clarks-originals-desert-boot-m-s141029-p0000009633#size=43',5,'\0'),(48,'22/12/2016 05:17:13','Panama Jack',189.70,'Sarenza','C:\\HEI\\data\\boots4.jpg','http://www.sarenza.com/panama-jack-panama-03-igloo-m-s773606-p0000146079',1,'\0'),(49,'22/12/2016 05:19:08','Azzaro',145.00,'Sarenza','C:\\HEI\\data\\derbies1.jpg','http://www.sarenza.com/azzaro-outino-s2261-p0000141028',3,'\0'),(50,'22/12/2016 05:20:49','Brett & Sons',131.00,'Sarenza','C:\\HEI\\data\\derbies2.jpg','http://www.sarenza.com/brett---sons-mark-s813476-p0000063474',3,'\0'),(51,'22/12/2016 05:22:41','Timberland',125.00,'Sarenza','C:\\HEI\\data\\baskets2.jpg','http://www.sarenza.com/timberland-bradstreet-half-cab-s3333-p0000127262',6,'\0');
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categorie` (
  `id_categorie` int(11) NOT NULL AUTO_INCREMENT,
  `nom_categorie` varchar(45) NOT NULL,
  `description_categorie` varchar(1200) NOT NULL,
  PRIMARY KEY (`id_categorie`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorie`
--

LOCK TABLES `categorie` WRITE;
/*!40000 ALTER TABLE `categorie` DISABLE KEYS */;
INSERT INTO `categorie` VALUES (1,'Boots','Les boots sont des chaussures montantes qui comportent pour la plupart des lacets mais qui peuvent aussi se refermer grâce à un système d’élastique. La boots peut être une chaussure de travail type Caterpillar ou Timberland, plus casual comme les fameuses Desert boots, plus élégantes comme les Chukka boots voire plus rock comme c’est le cas des Chelsea boots.'),(2,'Richelieu','Le Richelieu est la forme de chaussures réputée comme étant la plus élégante. Les lacets passent à travers des oeillets qui sont le plus souvent au nombre de 5 de part et d’autre. C’est le type de chaussures à porter par excellence au cours d’une cérémonie ou pour toute occasion formelle. Le Richelieu noir est un grand classique de la chaussure pour homme ! Il est par contre plus adapté aux personnes ayant le pied fin et le cou-de-pied pas trop développé. Nous vous invitons à découvrir notre sujet expliquant la différence entre un derby et un richelieu pour bien apprendre à différencier ces deux formes de chaussures.'),(3,'Derbies','Le derby est une chaussures basse dont les origines remontent au 18ème siècle. Une chaussure réputée confortable et appréciée par ceux qui ont le pied large ou le cou-de-pied développé. De part et d’autre d’un derby, on trouve deux empiècements de cuir appelés “quartiers”. Les lacets permettent de les resserrer pour maintenir la chaussure sur le pied. Moins élégantes que le richelieu, le derby peut néanmoins se parer de plusieurs décorations qui font oublier son aspect plus rustique lié aux coutures extérieures. Le derby peut être à bout droit, à bout golf fleuri, en cuir lisse, en veau velours ou encore en cuir grainé. Au pluriel, on parle de derbys ou derbies.'),(4,'Mocassins','Le mocassin est une chaussure basse, souple et légère qui se porte essentiellement l’été. Son origine est très ancienne. Les peuples nord-améridiens en porte notamment depuis des siècles. De manière plus contemporaine, le mocassin a été popularisé en Europe par l’italien Tod’s dans la fin des années 70. Plus précisément, il s’agissait d’un mocassin à picot. Autre forme de mocassin : la chaussure à bateaux proposée notamment par Sebago et Sperry Top-Sider. Le mocassin se porte essentiellement l’été, en bermuda, en chino ou en jeans. On l’associe souvent au style preppy pour son aspect chic décontracté.'),(5,'Desert Boots','A l’origine, la Desert boot n’a pas de vrai nom. C’est une chaussure que les officiers de l’armée anglaise portaient lors des missions dans les colonies “chaudes”. C’est Nathan Clark qui de retour de mission la commercialisa sous le nom qu’on connait. Ce derby montant, souple et non doublé protège du sable sans tenir trop chaud. Dans les années 50, la chaussure entre ainsi dans le monde civil via l’entreprise familiale Clarks. Il est courant de confondre desert boot et chukka, dont l’origine provient des joueurs de polo. Le bottier anglais Crockett & Jones semble être un des premiers à l’avoir proposé et les joueurs l’adoptèrent pour reposer leurs pieds après avoir quitté leurs bottes cavalières. Si l’on est en présence de deux versions de derbies montantes, les deux modèles sont distinguables en plusieurs points : la chukka a un aspect plus élégant, plus allongé avec une tige montée sur une semelle en cuir ou en gomme, la desert boot quand a elle a pour caractéristique son bout arrondi et une semelle en crêpe, plus adhérente et plus confortable. '),(6,'Baskets','L\'appellation “basket” désigne en général une chaussure de sport, cependant la mode “sneakers” arrivée dans le courant des années 80 a fait évoluer son utilisation : alors qu\'elle était essentiellement réservée à un usage sportif, elle est aujourd\'hui une pièce qui quasiment incontournable du vestimentaire masculin ! Ainsi les baskets vintage ou sneakers mode, sont aujourd\'hui devenues un vrai moyen de se démarquer en alliant confort et look, tout en restant près des valeurs originelles qui vont de la simple tennis à la chaussure de running. La tendance qui est longtemps restée sur la basket basse s\'est clairement tournée vers les baskets montantes, inspirées du Basket-ball et notamment avec la sneakers nike air jordan ou la basket Nike Air Force One qui est inspirée du célèbre Michael Jordan ou bien encore la Hummel historique. Aujourd\'hui des marques comme Veja, redonne un souffle aux baskets avec notamment des baskets écologiques.');
/*!40000 ALTER TABLE `categorie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commentaire`
--

DROP TABLE IF EXISTS `commentaire`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `commentaire` (
  `id_commentaire` int(11) NOT NULL AUTO_INCREMENT,
  `date_commentaire` varchar(25) DEFAULT NULL,
  `commentaire` varchar(255) NOT NULL,
  `nom_commentaire` varchar(10) NOT NULL,
  `idarticle` int(11) NOT NULL,
  PRIMARY KEY (`id_commentaire`),
  KEY `id_article_fk_idx` (`idarticle`),
  CONSTRAINT `id_article_fk` FOREIGN KEY (`idarticle`) REFERENCES `article` (`id_article`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commentaire`
--

LOCK TABLES `commentaire` WRITE;
/*!40000 ALTER TABLE `commentaire` DISABLE KEYS */;
INSERT INTO `commentaire` VALUES (115,'22/12/2016 06:09:22','Si vous êtes entre deux tailles, la taille du dessus est recommandée. ','Rémy',51),(117,'22/12/2016 06:11:40','Je commande mes chaussures sur ce site depuis des années parce que je gagne du temps et ne trouve aucune boutique en ville qui le propose un tel choix. Je trouve d ailleurs mes marques préférées. Je suis impressionnée par la rapidité de l envoi ,identique','Maxime',50),(118,'22/12/2016 06:12:19','super bottines super rapide pour la livraison bien emballe rien a redire pas de frais de port','Julien',35),(119,'22/12/2016 06:12:54','Tout est parfait du site à la livraison . Super site rien à redire !!! Bravo ...','kévin',43),(120,'22/12/2016 06:13:29','Génial. Jamais déçue.','Jean',46),(121,'22/12/2016 06:14:10','merci beaucoup suis ravie tout est parfait!!','Guillaume',44),(122,'22/12/2016 06:17:04','Si je dis à mon père que j\'ai encore dépensé mon argent pour ces chaussures je ne peux plus écrire à cette he..','Karel',44);
/*!40000 ALTER TABLE `commentaire` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `newsletter`
--

DROP TABLE IF EXISTS `newsletter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `newsletter` (
  `id_inscription` int(11) NOT NULL AUTO_INCREMENT,
  `mail` varchar(45) NOT NULL,
  PRIMARY KEY (`id_inscription`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `newsletter`
--

LOCK TABLES `newsletter` WRITE;
/*!40000 ALTER TABLE `newsletter` DISABLE KEYS */;
INSERT INTO `newsletter` VALUES (1,'remy.vitse@hei.fr'),(2,'remy.vitse@hei.yncrea.fr'),(3,'contact@baskets.fr');
/*!40000 ALTER TABLE `newsletter` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-22  2:13:27
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: devweb_test
-- ------------------------------------------------------
-- Server version	5.7.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article` (
  `id_article` int(11) NOT NULL AUTO_INCREMENT,
  `date_publication` date NOT NULL,
  `marque` varchar(45) NOT NULL,
  `prix` decimal(5,2) NOT NULL,
  `site` varchar(45) NOT NULL,
  `photo` varchar(45) NOT NULL,
  `lien` varchar(255) NOT NULL,
  `id_categorie` int(11) NOT NULL,
  PRIMARY KEY (`id_article`),
  KEY `id_categorie_idx` (`id_categorie`),
  CONSTRAINT `id_categorie_fk` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id_categorie`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categorie` (
  `id_categorie` int(11) NOT NULL AUTO_INCREMENT,
  `nom_categorie` varchar(45) NOT NULL,
  `description_categorie` varchar(255) NOT NULL,
  PRIMARY KEY (`id_categorie`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorie`
--

LOCK TABLES `categorie` WRITE;
/*!40000 ALTER TABLE `categorie` DISABLE KEYS */;
/*!40000 ALTER TABLE `categorie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commentaire`
--

DROP TABLE IF EXISTS `commentaire`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `commentaire` (
  `id_commentaire` int(11) NOT NULL AUTO_INCREMENT,
  `date_commentaire` datetime NOT NULL,
  `commentaire` varchar(255) NOT NULL,
  `nom_commentaire` varchar(45) NOT NULL,
  `id_article` int(11) NOT NULL,
  PRIMARY KEY (`id_commentaire`),
  KEY `id_article_fk_idx` (`id_article`),
  CONSTRAINT `id_article_fk` FOREIGN KEY (`id_article`) REFERENCES `article` (`id_article`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commentaire`
--

LOCK TABLES `commentaire` WRITE;
/*!40000 ALTER TABLE `commentaire` DISABLE KEYS */;
/*!40000 ALTER TABLE `commentaire` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `newsletter`
--

DROP TABLE IF EXISTS `newsletter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `newsletter` (
  `id_inscription` int(11) NOT NULL AUTO_INCREMENT,
  `mail` varchar(45) NOT NULL,
  PRIMARY KEY (`id_inscription`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `newsletter`
--

LOCK TABLES `newsletter` WRITE;
/*!40000 ALTER TABLE `newsletter` DISABLE KEYS */;
INSERT INTO `newsletter` VALUES (1,'remy.vitse@hei.fr'),(2,'remy.vitse@hei.yncrea.fr'),(3,'contact@baskets.fr');
/*!40000 ALTER TABLE `newsletter` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-22  2:13:27
