package downloadFile;

import lombok.Data;

@Data
public class Quote {
    private String time;//成交时间
    private String price;//成交价格
    private String volatility;//价格波动
    private String volume;//成交量(手)
    private String amount;//成交额(元)
    private String buyOrSell;//性质(买盘还是卖盘)
}
