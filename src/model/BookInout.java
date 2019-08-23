package model;

public class BookInout {
public BookInout() {
	
}
	// 책번호
	private int bioNo;

	// 빌린사람아이디
	private String bioId;
	
	private int biobookNo;

	public BookInout(int bioNo, String bioId, int biobookNo) {
		this.bioNo = bioNo;
		this.bioId = bioId;
		this.biobookNo = biobookNo;
	}

	public int getBioNo() {
		return bioNo;
	}

	public void setBioNo(int bioNo) {
		this.bioNo = bioNo;
	}

	public String getBioId() {
		return bioId;
	}

	public void setBioId(String bioId) {
		this.bioId = bioId;
	}

	public int getBiobookNo() {
		return biobookNo;
	}

	public void setBiobookNo(int biobookNo) {
		this.biobookNo = biobookNo;
	}

}