package com.web.demo.entity;
// Generated Jul 5, 2021, 11:28:02 AM by Hibernate Tools 5.0.6.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Games generated by hbm2java
 */
@Entity
@Table(name = "games", catalog = "megalodondb")
public class Games implements java.io.Serializable {

	private Integer idGame;
	private Discount discount;
	private String nameGame;
	private String producterGame;
	private String publisherGame;
	private Date releaseYearGame;
	private String descriptionGame;
	private String linkVideo;
	private Long price;
	private Long priceFix;
	private Float rateGame;
	private Integer countSell;
	private String linkGame;
	private Integer countRate;
	private String processor;
	private String ram;
	private String freeStorage;
	private String vga;
	private Set<ImageData> imageDatas = new HashSet<ImageData>(0);
	private Set<GameCategory> gameCategories = new HashSet<GameCategory>(0);
	private Set<ActiveGame> activeGames = new HashSet<ActiveGame>(0);
	private Set<CommentGame> commentGames = new HashSet<CommentGame>(0);
	private Set<BillDetail> billDetails = new HashSet<BillDetail>(0);
	private Set<SlideShow> slideShows = new HashSet<SlideShow>(0);

	public Games() {
	}

	public Games(String nameGame) {
		this.nameGame = nameGame;
	}

	public Games(Discount discount, String nameGame, String producterGame, String publisherGame, Date releaseYearGame,
			String descriptionGame, String linkVideo, Long price, Long priceFix, Float rateGame, Integer countSell,
			String linkGame, Integer countRate, String processor, String ram, String freeStorage, String vga,
			Set<ImageData> imageDatas, Set<GameCategory> gameCategories, Set<ActiveGame> activeGames,
			Set<CommentGame> commentGames, Set<BillDetail> billDetails, Set<SlideShow> slideShows) {
		this.discount = discount;
		this.nameGame = nameGame;
		this.producterGame = producterGame;
		this.publisherGame = publisherGame;
		this.releaseYearGame = releaseYearGame;
		this.descriptionGame = descriptionGame;
		this.linkVideo = linkVideo;
		this.price = price;
		this.priceFix = priceFix;
		this.rateGame = rateGame;
		this.countSell = countSell;
		this.linkGame = linkGame;
		this.countRate = countRate;
		this.processor = processor;
		this.ram = ram;
		this.freeStorage = freeStorage;
		this.vga = vga;
		this.imageDatas = imageDatas;
		this.gameCategories = gameCategories;
		this.activeGames = activeGames;
		this.commentGames = commentGames;
		this.billDetails = billDetails;
		this.slideShows = slideShows;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "Id_game", unique = true, nullable = false)
	public Integer getIdGame() {
		return this.idGame;
	}

	public void setIdGame(Integer idGame) {
		this.idGame = idGame;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Id_discount")
	public Discount getDiscount() {
		return this.discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	@Column(name = "Name_game", nullable = false, length = 45)
	public String getNameGame() {
		return this.nameGame;
	}

	public void setNameGame(String nameGame) {
		this.nameGame = nameGame;
	}

	@Column(name = "Producter_game", length = 45)
	public String getProducterGame() {
		return this.producterGame;
	}

	public void setProducterGame(String producterGame) {
		this.producterGame = producterGame;
	}

	@Column(name = "Publisher_game", length = 45)
	public String getPublisherGame() {
		return this.publisherGame;
	}

	public void setPublisherGame(String publisherGame) {
		this.publisherGame = publisherGame;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ReleaseYear_game", length = 10)
	public Date getReleaseYearGame() {
		return this.releaseYearGame;
	}

	public void setReleaseYearGame(Date releaseYearGame) {
		this.releaseYearGame = releaseYearGame;
	}

	@Column(name = "Description_game", length = 65535)
	public String getDescriptionGame() {
		return this.descriptionGame;
	}

	public void setDescriptionGame(String descriptionGame) {
		this.descriptionGame = descriptionGame;
	}

	@Column(name = "Link_video", length = 100)
	public String getLinkVideo() {
		return this.linkVideo;
	}

	public void setLinkVideo(String linkVideo) {
		this.linkVideo = linkVideo;
	}

	@Column(name = "Price", precision = 18, scale = 0)
	public Long getPrice() {
		return this.price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	@Column(name = "Price_fix", precision = 18, scale = 0)
	public Long getPriceFix() {
		return this.priceFix;
	}

	public void setPriceFix(Long priceFix) {
		this.priceFix = priceFix;
	}

	@Column(name = "Rate_game", precision = 12, scale = 0)
	public Float getRateGame() {
		return this.rateGame;
	}

	public void setRateGame(Float rateGame) {
		this.rateGame = rateGame;
	}

	@Column(name = "Count_sell")
	public Integer getCountSell() {
		return this.countSell;
	}

	public void setCountSell(Integer countSell) {
		this.countSell = countSell;
	}

	@Column(name = "Link_game", length = 150)
	public String getLinkGame() {
		return this.linkGame;
	}

	public void setLinkGame(String linkGame) {
		this.linkGame = linkGame;
	}

	@Column(name = "count_rate")
	public Integer getCountRate() {
		return this.countRate;
	}

	public void setCountRate(Integer countRate) {
		this.countRate = countRate;
	}

	@Column(name = "Processor", length = 50)
	public String getProcessor() {
		return this.processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	@Column(name = "RAM", length = 50)
	public String getRam() {
		return this.ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	@Column(name = "Free_storage", length = 50)
	public String getFreeStorage() {
		return this.freeStorage;
	}

	public void setFreeStorage(String freeStorage) {
		this.freeStorage = freeStorage;
	}

	@Column(name = "VGA", length = 50)
	public String getVga() {
		return this.vga;
	}

	public void setVga(String vga) {
		this.vga = vga;
	}

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "games")
//	public Set<ImageData> getImageDatas() {
//		return this.imageDatas;
//	}
//
//	public void setImageDatas(Set<ImageData> imageDatas) {
//		this.imageDatas = imageDatas;
//	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "games")
	public Set<GameCategory> getGameCategories() {
		return this.gameCategories;
	}

	public void setGameCategories(Set<GameCategory> gameCategories) {
		this.gameCategories = gameCategories;
	}

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "games")
//	public Set<ActiveGame> getActiveGames() {
//		return this.activeGames;
//	}
//
//	public void setActiveGames(Set<ActiveGame> activeGames) {
//		this.activeGames = activeGames;
//	}

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "games")
//	public Set<CommentGame> getCommentGames() {
//		return this.commentGames;
//	}
//
//	public void setCommentGames(Set<CommentGame> commentGames) {
//		this.commentGames = commentGames;
//	}

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "games")
//	public Set<BillDetail> getBillDetails() {
//		return this.billDetails;
//	}
//
//	public void setBillDetails(Set<BillDetail> billDetails) {
//		this.billDetails = billDetails;
//	}

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "games")
//	public Set<SlideShow> getSlideShows() {
//		return this.slideShows;
//	}
//
//	public void setSlideShows(Set<SlideShow> slideShows) {
//		this.slideShows = slideShows;
//	}

}
