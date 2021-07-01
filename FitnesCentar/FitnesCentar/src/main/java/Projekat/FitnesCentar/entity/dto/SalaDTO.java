package Projekat.FitnesCentar.entity.dto;

public class SalaDTO {
		private long id;
		private int kapacitet;
		private String oznakaSale;
		public SalaDTO(long id, int kapacitet, String oznakaSale) {
			super();
			this.id = id;
			this.kapacitet = kapacitet;
			this.oznakaSale = oznakaSale;
		}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public int getKapacitet() {
			return kapacitet;
		}
		public void setKapacitet(int kapacitet) {
			this.kapacitet = kapacitet;
		}
		public String getOznakaSale() {
			return oznakaSale;
		}
		public void setOznakaSale(String oznakaSale) {
			this.oznakaSale = oznakaSale;
		}
		
}