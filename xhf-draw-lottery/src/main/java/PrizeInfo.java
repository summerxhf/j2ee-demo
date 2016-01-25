/**
 * Description:奖品信息实体类.
 * Created  2015/12/25 15:40  by xinghaifang
 */
public class PrizeInfo {

    /**
     * 奖品id
     */
    private Long prizeId;

    /**
     * 奖品名称
     */
    private String prizeName;
    /**
     * 每类奖品的总数
     */
    private String prizeTotal;

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    public String getPrizeTotal() {
        return prizeTotal;
    }

    public void setPrizeTotal(String prizeTotal) {
        this.prizeTotal = prizeTotal;
    }
    public Long getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(Long prizeId) {
        this.prizeId = prizeId;
    }
}
