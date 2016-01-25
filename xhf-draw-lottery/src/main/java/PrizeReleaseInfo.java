import java.util.Date;

/**
 * Description:奖品释放信息实体类.
 * Created  2015/12/25 15:44  by xinghaifang
 */
public class PrizeReleaseInfo {
    /**
     * 奖品释放id
     */
    private Long prizeReleaseId;
    /**
     * 奖品id
     */
    private Long prizeId;
    /**
     * 奖品释放时间点.
     */
    private Date releaseTime;

    /**
     * 奖品剩余个数.
     */
    private Integer prizeLeftNums;

    public Integer getPrizeLeftNums() {
        return prizeLeftNums;
    }

    public void setPrizeLeftNums(Integer prizeLeftNums) {
        this.prizeLeftNums = prizeLeftNums;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Long getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(Long prizeId) {
        this.prizeId = prizeId;
    }

    public Long getPrizeReleaseId() {
        return prizeReleaseId;
    }

    public void setPrizeReleaseId(Long prizeReleaseId) {
        this.prizeReleaseId = prizeReleaseId;
    }


}
