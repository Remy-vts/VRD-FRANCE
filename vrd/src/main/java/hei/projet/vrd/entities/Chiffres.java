package hei.projet.vrd.entities;

public class Chiffres {
		private Integer idchiffres;
		private String titre;
		private int chiffre;
		
		public Chiffres(Integer idchiffres, String titre, Integer chiffre) {
			super();
			this.setIdchiffres(idchiffres);
			this.setTitre(titre);
			this.setChiffre(chiffre);
		}

		public int getChiffre() {
			return chiffre;
		}

		public void setChiffre(int chiffre) {
			this.chiffre = chiffre;
		}

		public String getTitre() {
			return titre;
		}

		public void setTitre(String titre) {
			this.titre = titre;
		}

		public Integer getIdchiffres() {
			return idchiffres;
		}

		public void setIdchiffres(Integer idchiffres) {
			this.idchiffres = idchiffres;
		}

}
