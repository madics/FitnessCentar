package Projekat.FitnesCentar.entity.dto;

public class SalaDTO {
	private long id;
		private int kapacitet;
		private String oznakaSale;
		private long fcid;
		public SalaDTO() {}
		public SalaDTO(long id, int kapacitet, String oznakaSale) {
			super();
			this.id = id;
			this.kapacitet = kapacitet;
			this.oznakaSale = oznakaSale;
		}
		public SalaDTO(long id, int kapacitet, String oznakaSale, long fcid) {
			super();
			this.id = id;
			this.kapacitet = kapacitet;
			this.oznakaSale = oznakaSale;
			this.fcid = fcid;
		}
		public SalaDTO( int kapacitet, String oznakaSale, long fcid) {
			super();
			this.kapacitet = kapacitet;
			this.oznakaSale = oznakaSale;
			this.fcid = fcid;
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
		public long getFcid() {
			return fcid;
		}
		public void setFcid(long fcid) {
			this.fcid = fcid;
		}
		
}