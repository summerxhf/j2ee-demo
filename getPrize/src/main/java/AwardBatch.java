import java.util.Date;

/**
 * Description:奖品信息,个数,以及最后抽取的该类奖品的时间.
 * Created  2015/12/24 13:35  by xinghaifang
 */
public class AwardBatch {
    /**
     * 表id
     */
    private Long awardBatchId;
    /**
     * 奖品的名称
     */
    private String name;
    /**
     * 奖品总数
     */
    private Integer amount;
    /**
     * 奖品剩余量
     */
    private Integer balance;


    /**
     * 哪天的奖品.
     */
    private String strDate;

    /**
     * 奖品最后更新时间.
     */
    private Date lastUpdateTime;

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getAmount() {
        return amount;
    }
    public Long getAwardBatchId() {
        return awardBatchId;
    }

    public void setAwardBatchId(Long awardBatchId) {
        this.awardBatchId = awardBatchId;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getStrDate() {
        return strDate;
    }

    public void setStrDate(String strDate) {
        this.strDate = strDate;
    }

}
