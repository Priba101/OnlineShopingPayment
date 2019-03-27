package main;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mapiranje {
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private long id;
		private String tip;
		private int broj;
		private int security_code;
		private String datum_isteka;
		private String nosilac_kartice;
		private String korisnik_kartice_id;
		private int stanje;
		
		protected Mapiranje() {}
		
		public Mapiranje(long id,String tip,int broj,int security_code,
				String datum_isteka,String nosilac_kartice,
				String korisnik_kartice_id,int stanje) {
			super();
			this.id=id;
			this.tip=tip;
			this.broj=broj;
			this.security_code=security_code;
			this.datum_isteka=datum_isteka;
			this.nosilac_kartice=nosilac_kartice;
			this.korisnik_kartice_id=korisnik_kartice_id;
			this.stanje=stanje;
		}

	    @Override
	    public String toString() {
	        return String.format(
	                "Mapiranje[id=%d, tip='%s', broj='%d', security_code='%d', datum_isteka='%s', nosilac_kartice='%s'"
	                + ", korisnik_kartice_id='%s', stanje='%d']",
	                id,tip,broj,security_code,datum_isteka,nosilac_kartice,korisnik_kartice_id,stanje);
	    }
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getTip() {
			return tip;
		}

		public void setTip(String tip) {
			this.tip = tip;
		}

		public int getBroj() {
			return broj;
		}

		public void setBroj(int broj) {
			this.broj = broj;
		}

		public int getSecurity_code() {
			return security_code;
		}

		public void setSecurity_code(int security_code) {
			this.security_code = security_code;
		}

		public String getDatum_isteka() {
			return datum_isteka;
		}

		public void setDatum_isteka(String datum_isteka) {
			this.datum_isteka = datum_isteka;
		}

		public String getNosilac_kartice() {
			return nosilac_kartice;
		}

		public void setNosilac_kartice(String nosilac_kartice) {
			this.nosilac_kartice = nosilac_kartice;
		}

		public String getKorisnik_kartice_id() {
			return korisnik_kartice_id;
		}

		public void setKorisnik_kartice_id(String korisnik_kartice_id) {
			this.korisnik_kartice_id = korisnik_kartice_id;
		}

		public int getStanje() {
			return stanje;
		}

		public void setStanje(int stanje) {
			this.stanje = stanje;
		}
		
}
