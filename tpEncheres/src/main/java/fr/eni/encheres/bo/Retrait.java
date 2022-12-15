package fr.eni.encheres.bo;

public class Retrait {

	private int numeroRetrait;
	private Article article;
	private String rue;
	private String codePostal;
	private String ville;
	/**
	 * @param numeroRetrait
	 * @param article
	 * @param rue
	 * @param codePostal
	 * @param ville
	 */
	public Retrait(int numeroRetrait, Article article, String rue, String codePostal, String ville) {
		this.numeroRetrait = numeroRetrait;
		this.article = article;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	
	
	/**
	 * @param rue
	 * @param codePostal
	 * @param ville
	 */
	public Retrait(String rue, String codePostal, String ville) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}


	/**
	 * @return the numeroRetrait
	 */
	public int getNumeroRetrait() {
		return numeroRetrait;
	}
	/**
	 * @param numeroRetrait the numeroRetrait to set
	 */
	public void setNumeroRetrait(int numeroRetrait) {
		this.numeroRetrait = numeroRetrait;
	}
	/**
	 * @return the article
	 */
	public Article getArticle() {
		return article;
	}
	/**
	 * @param article the article to set
	 */
	public void setArticle(Article article) {
		this.article = article;
	}
	/**
	 * @return the rue
	 */
	public String getRue() {
		return rue;
	}
	/**
	 * @param rue the rue to set
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}
	/**
	 * @return the codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}
	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}
	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Retrait [numeroRetrait=").append(numeroRetrait).append(", article=").append(article)
				.append(", rue=").append(rue).append(", codePostal=").append(codePostal).append(", ville=")
				.append(ville).append("]");
		return builder.toString();
	}
	
	
}
