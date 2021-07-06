package Projekat.FitnesCentar.entity.dto;

public class OcenaDTO {
	private long id;
	private int ocena;
	private long clanId;
	private long terminId;
	public OcenaDTO() {}
	public OcenaDTO(int ocena, long clanId, long terminId) {
		super();
		this.ocena = ocena;
		this.clanId = clanId;
		this.terminId = terminId;
	}
	public OcenaDTO(int ocena,long terminId) {
		super();
		this.ocena = ocena;
		this.terminId = terminId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getOcena() {
		return ocena;
	}
	public void setOcena(int ocena) {
		this.ocena = ocena;
	}
	public long getClanId() {
		return clanId;
	}
	public void setClanId(long clanId) {
		this.clanId = clanId;
	}
	public long getTerminId() {
		return terminId;
	}
	public void setTerminId(long terminId) {
		this.terminId = terminId;
	}

}
