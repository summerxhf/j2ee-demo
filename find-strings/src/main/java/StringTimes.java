import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description:
 * Created  2015/11/17 17:58  by xinghaifang
 */
public class StringTimes {
    /**
     *
     * The number of occurrences of find keyword in srcText
     *
     * @param srcText
     * @param keyword
     * @return
     */
    public static int findStr1(String srcText, String keyword) {
        int count = 0;
        int leng = srcText.length();
        int j = 0;
        for (int i = 0; i < leng; i++) {
            if (srcText.charAt(i) == keyword.charAt(j)) {
                j++;
                if (j == keyword.length()) {
                    count++;
                    j = 0;
                }
            } else {
                i = i - j;// should rollback when not match
                j = 0;
            }
        }

        return count;
    }

    public static int findStr2(String srcText, String keyword) {
        int count = 0;
        Pattern p = Pattern.compile(keyword);
        Matcher m = p.matcher(srcText);
        while (m.find()) {
            count++;
        }
        return count;
    }

    public static int findStr3(String srcText, String keyword) {
        return findStr(srcText, keyword, 0);
    }

        public static List<String> getArtileImgList( String htmlStr){
                if ( null == htmlStr){
                        return null;
                }
                List<String> imgList = new ArrayList<String>();
                String regexImage  = "<img.+?src\\s*=\\s*['|\"]?\\s*([^'\"\\s>]+).+?/?>?";
                String ImageSrcStr="";
                Pattern p = Pattern.compile(regexImage,Pattern.CASE_INSENSITIVE);
                Matcher m = p.matcher(htmlStr);
                while(m.find()){
                        ImageSrcStr = m.group(1);
                        if ( ImageSrcStr.indexOf( ".ddimg.cn") >= 0){//外链图片不进行处理
                                if ( ImageSrcStr.indexOf("http://img3") >= 0){
                                        int index = ImageSrcStr.indexOf(".");
                                        ImageSrcStr = "http://img62"+ImageSrcStr.substring( index);
                                }
                                imgList.add( ImageSrcStr);
                        }
                }
                return imgList;
        }

    public static int findStr(String srcText, String keyWord, int pos) {
        int i, j, k = 0;
        i = pos;
        j = 0;
        while (i < srcText.length() && j < keyWord.length()) {
            if (srcText.charAt(i) == keyWord.charAt(j)) {
                ++i;
                ++j;
                if (j == keyWord.length()) {
                    k = k + 1;// k++
                    j = 0;
                }
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        String content="<p>\t\t\t\t\t\t\t\t\t\t\t</p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><!--?xml version=\"1.0\" encoding=\"utf-8\" ?--><meta http-equiv=\"Content-Type\" content=\"application/xhtml+xml; charset=utf-8\"/><style type=\"text/css\">@charset \"utf-8\";\n" +
                "/* CSS Document */\n" +
                ".frontCover {\n" +
                "\ttext-align:center;\n" +
                "\tborder:0;\n" +
                "}/*封皮*/\n" +
                "a {\n" +
                "\ttext-decoration:none;\n" +
                "}\n" +
                "h1.Sequence, h1.chapterCaption {\n" +
                "\tfont-family:'';\n" +
                "\tfont-size: 1.05em;\n" +
                "\tline-height: 1.5em;\n" +
                "\ttext-align: left;\n" +
                "\ttext-indent:0;\n" +
                "\tcolor:#c36500;\n" +
                "\tmargin:5pt 0;\n" +
                "\tletter-spacing:auto;\n" +
                "}   /*一级标题*/\n" +
                "h2.sectionHeading {\n" +
                "\tfont-family:'';\n" +
                "\tfont-size: 1.0em;\n" +
                "\tline-height: 1.5em;\n" +
                "\ttext-align: center;\n" +
                "\ttext-indent:0;\n" +
                "\tcolor:#c36500;\n" +
                "\tmargin:5pt 0;\n" +
                "\tletter-spacing:auto;\n" +
                "} /*二级标题*/\n" +
                "h3.listHeadline {\n" +
                "\tfont-family:'';\n" +
                "\tfont-size: 0.95em;\n" +
                "\tline-height: 1.5em;\n" +
                "\ttext-align: left;\n" +
                "\ttext-indent:0;\n" +
                "\tcolor:#7a3c00;\n" +
                "\tmargin:5pt 0;\n" +
                "\tletter-spacing:auto;\n" +
                "} /*三级标题*/\n" +
                "h4.lastTitle {\n" +
                "\tfont-family:'';\n" +
                "\tfont-size: 0.9em;\n" +
                "\tline-height: 1.3em;\n" +
                "\ttext-align: left;\n" +
                "\tcolor:#7a3c00;\n" +
                "\ttext-indent:0;\n" +
                "\tmargin:5pt 0;\n" +
                "\tletter-spacing:auto;\n" +
                "} /*四级标题*/\n" +
                "h5.fiveTitle {\n" +
                "\tfont-family:'';\n" +
                "\tfont-size: 0.85em;\n" +
                "\tline-height: 1.3em;\n" +
                "\ttext-align: left;\n" +
                "\ttext-indent:0;\n" +
                "\tmargin:3pt 0;\n" +
                "\tletter-spacing:auto;\n" +
                "} /*五级标题*/\n" +
                "h6.sixTitle {\n" +
                "\tfont-family:'';\n" +
                "\tfont-size: 0.85em;\n" +
                "\tline-height: 1.3em;\n" +
                "\ttext-align: left;\n" +
                "\ttext-indent:0;\n" +
                "\tmargin:3pt 0;\n" +
                "\tletter-spacing:auto;\n" +
                "} /*六级标题*/\n" +
                ".bodyContent {\n" +
                "\tfont-family:'';\n" +
                "\tfont-size: 0.85em;\n" +
                "\tline-height: 1.5em;\n" +
                "\ttext-align:left;\n" +
                "\ttext-indent: 2em;\n" +
                "\tmargin:10pt 0;\n" +
                "\tletter-spacing:auto;\n" +
                "} /*正文内容*/\n" +
                ".notNaturalParagraph{\n" +
                "\tfont-family:'';\n" +
                "\tfont-size: 0.85em;\n" +
                "\tline-height: 1.5em;\n" +
                "\ttext-align:left;\n" +
                "\ttext-indent: 2em;\n" +
                "\tmargin:0;\n" +
                "\tletter-spacing:auto;\n" +
                "}/*非自然段落*/\n" +
                ".dyfirst{\t\n" +
                "\tfont-family:'';\n" +
                "\tfont-size: 0.85em;\n" +
                "\tline-height: 1.5em;\n" +
                "\ttext-align:left;\t\n" +
                "\tmargin:10pt 0;\n" +
                "\tletter-spacing:auto;\n" +
                "}\n" +
                ".dyfirstLetter{\n" +
                "\tfloat: left;\n" +
                "\tfont-size: 280%;\n" +
                "\tfont-weight:bold;\n" +
                "\tcolor:#c36500;\n" +
                "\tline-height: 1;    \n" +
                "\ttext-transform: uppercase;\n" +
                "}/*首行文字下沉效果*/\n" +
                ".fnoteRight {\n" +
                "\tfont-family:'';\n" +
                "\tfont-size: 0.8em;\n" +
                "\tline-height: 1.5em;\n" +
                "\ttext-align:right;\n" +
                "\tletter-spacing:auto;\n" +
                "} /*右下角说明*/\n" +
                ".bodyReference {\n" +
                "\tfont-family:'';\n" +
                "\tfont-size:0.85em;\n" +
                "\ttext-align:left;\n" +
                "\ttext-indent:2.0em;\n" +
                "\tline-height: 1.5em;\n" +
                "\tletter-spacing:auto;\n" +
                "} /*书信称谓*/\n" +
                ".bodyLetter{\n" +
                "\tfont-family:'';\n" +
                "\tfont-size:0.75em;\n" +
                "\ttext-align:left;\n" +
                "\ttext-indent:2.0em;\n" +
                "\tline-height: 1.5em;\n" +
                "\tletter-spacing:auto;\n" +
                "\tfont-style:italic;\n" +
                "}/*书信内容*/\n" +
                ".titleQuot {\n" +
                "\tfont-family:'';\n" +
                "\tfont-size: 0.8em;\n" +
                "\tline-height: 1.5em;\n" +
                "\ttext-align:left;\n" +
                "\ttext-indent: 24px;\n" +
                "\tmargin:5pt 0;\n" +
                "\tletter-spacing:auto;\n" +
                "}/*引文标题*/\n" +
                ".conQuot {\n" +
                "\tfont-family:'';\n" +
                "\tfont-size: 0.75em;\n" +
                "\tline-height: 1.5em;\n" +
                "\ttext-align:left;\n" +
                "\ttext-indent: 48px;\n" +
                "\tmargin:5pt 0;\n" +
                "\tletter-spacing:auto;\n" +
                "}/*引文*/\n" +
                ".bodyPic {\n" +
                "\ttext-align:center;\n" +
                "\tfont-size:0%;\n" +
                "} /*正文图表*/\n" +
                ".imgDescript {\n" +
                "\tfont-family:'';\n" +
                "\tfont-size:0.7em;\n" +
                "\tline-height:1.5em;\n" +
                "\ttext-align:center;\n" +
                "\ttext-indent:0;\n" +
                "\tcolor:#a25400;\n" +
                "\tletter-spacing:auto;\n" +
                "} /*图表注释*/\n" +
                ".tableCaption{\n" +
                "    font-family:'';\n" +
                "\tfont-size:0.85em;\n" +
                "\tline-height:1.5em;\n" +
                "\ttext-align:center;\n" +
                "\ttext-indent:0;\n" +
                "\tcolor:#a25400;\n" +
                "\tletter-spacing:auto;\n" +
                "}/*正文中表格表头样式*/\n" +
                ".borderColor{\n" +
                "   border:2px solid #a25400;\n" +
                "}/*边框样式*/\n" +
                ".bgroundColor{\n" +
                "   background:#F8F2DA;\n" +
                "}/*段落底色*/\n" +
                ".signImg {\n" +
                "\ttext-align:right;\n" +
                "\tfont-size:0%;\n" +
                "}/*正文右下角签名图片*/\n" +
                ".noteTitle {\n" +
                "\tfont-family:'';\n" +
                "\tfont-size:0.8em;\n" +
                "\tline-height:1.5em;\n" +
                "\tfont-weight:bold;\n" +
                "\ttext-align:left;\n" +
                "\ttext-indent:0;\n" +
                "\tletter-spacing:auto;\n" +
                "} /*附注*/\n" +
                ".noteContent {\n" +
                "\tfont-family:'';\n" +
                "\tfont-size:0.6em;\n" +
                "\tline-height:1.5em;\n" +
                "\ttext-align:left;\n" +
                "\ttext-indent:2em;\n" +
                "\tletter-spacing:auto;\n" +
                "} /*附注说明*/\n" +
                ".bodyPoem {\n" +
                "\tfont-family:'';\n" +
                "\tfont-size:1.0em;\n" +
                "\ttext-align:center;\n" +
                "\tline-height:1.5em;\n" +
                "\tletter-spacing:auto;\n" +
                "} /*诗词*/\n" +
                ".conAuthor {\n" +
                "\tfont-family:'';\n" +
                "\tfont-size:0.9em;\n" +
                "\ttext-align:right;\n" +
                "\tline-height:1.5em;\n" +
                "\tpadding-right:4em;\n" +
                "\tletter-spacing:auto;\n" +
                "} /*诗词作者*/\n" +
                ".poemText {\n" +
                "\tfont-family:'';\n" +
                "\tfont-size:0.8em;\n" +
                "\ttext-align:center;\n" +
                "\tline-height:1.5em;\n" +
                "\tletter-spacing:auto;\n" +
                "} /*诗词正文*/\n" +
                "span.super {\n" +
                "\tfont-size:0.7em;\n" +
                "\tvertical-align: super;\n" +
                "} /*数字上标*/\n" +
                "span.sub {\n" +
                "\tfont-size:0.7em;\n" +
                "\tvertical-align: sub;\n" +
                "} /*数字下标*/\n" +
                "span.subScript {\n" +
                "\tfont-size:0.7em;\n" +
                "\tvertical-align: super;\n" +
                "}/*跳转注标*/\n" +
                ".bold {\n" +
                "\tfont-weight:bold;\n" +
                "}/*加粗*/\n" +
                ".left {\n" +
                "\ttext-align:left;\n" +
                "\ttext-indent:0;\n" +
                "}/*左对齐*/\n" +
                ".center {\n" +
                "\ttext-align:center;\n" +
                "\ttext-indent:0;\n" +
                "}/*居中对齐*/\n" +
                ".right {\n" +
                "\ttext-align:right;\n" +
                "\ttext-indent:0;\n" +
                "}/*右对齐*/\n" +
                ".indentS {\n" +
                "\ttext-indent:2em;\n" +
                "\tmargin:5pt 0;\n" +
                "}/*其它缩进24像素*/\n" +
                ".indentT {\n" +
                "\ttext-indent:3em;\n" +
                "\tmargin:5pt 0;\n" +
                "}/*其它缩进36像素*/\n" +
                ".indentF {\n" +
                "\ttext-indent:4em;\n" +
                "\tmargin:5pt 0;\n" +
                "}/*其它缩进48像素*/\n" +
                ".emphasis {\n" +
                "\ttext-decoration:underline;\n" +
                "}/*着重强调加下划线*/\n" +
                ".textItalic {\n" +
                "\tfont-style:italic;\n" +
                "}/*斜体*/\n" +
                ".conLink {\n" +
                "}/*正文中网址*/\n" +
                ".rareFont {\n" +
                "\twidth:0.8em;\n" +
                "}/*正文中生僻字图片代替*/\n" +
                ".subHead {\n" +
                "\ttext-align:right;\n" +
                "}/*副标题*/</style><title>第一节  先发制人，建立底仓</title><h2 class=\"sectionHeading\">第一节 先发制人，建立底仓</h2><p class=\"bodyContent\">完成标的的选择只是万里长征的第一步，对于主力资金而言接下来最重要的就是用米下炊——何时下、下多少的问题，也就是选择时机入场以及建立底仓的问题。时机的选择具有举足轻重的作用，就算是一只再好的标的通常也难敌市场的系统性风险，虽然是金子总会发光，但这个过程难免会让人背负不少压力，而且这个压力本身也并不是不可避免的，如果一开始就背负太大的压力，无疑将会对投资者的情绪或既定的策略产生干扰。当然对于主力资金而言，其运作一般都会被一套严格的纪律制约着，以避免非理性行为或重大错误的产生，但这样做或多或少会产生一些影响，影响利润的最大化。所以对于买点的把握至关重要，需要深思熟虑，不轻易出手，出手必运作到底，一般来说这些都是资金管理者遵循的思路，因为他们懂得时机的重要性以及严肃性。</p><p class=\"bodyContent\">对于众多投资者而言，为何难以从市场中盈利，反而更多的是亏损？可以说很大原因在于众多投资者操作的随意性以及缺乏纪律性。随性的思维模式指导下的行动最终的结果百分之八十将会惨淡收场，不得善终。对于为何随性操作或频繁操作大多会让人受伤害，其中缘由我们在下面章节中将重点阐述。当然读完主力建仓思维和建仓时主力惯用的一些手法后，读者对其中的缘由也能略知一二。对比个人投资者，机构投资者具备个人投资者无法企及的很多优势，如资金、技术信息、专业水平等，这些优势造就了很多时候主力资金先知先觉，先人一步的动作，占据相对主动有利的位置。后知后觉或看不懂其中缘由的投资者很可能就被市场，也就是被主力资金牵着鼻子走，这也是常见的市场现象，众多投资者追涨杀跌、拼命厮杀最终回过头来发现还是在原地踏步，或走进了漩涡无法自拔。要想做到与主力资金同步，先知先觉，并不是一件易事，可以说一般投资者难以企及，一时的同步可能，长期如此几乎不可能，市场里没有神仙。追究其中缘由，存在很多方面的原因，既有主观的人为方面的原因，也存在市场本身运行规律等客观方面的原因。</p><p class=\"bodyContent\">主观人为方面的原因，主要是指主力资金运作手法。众所周知，看到一只好的标的，对于有限的资金而言，谁都希望能够用有限的资金买到更多的股票。而在资金有限的条件下，唯一的办法就是个股单价下降，我们才能实现用有限的资金买到更多数量的个股的目的，也就是考虑买入价格的问题。对于个人投资者如此，对于机构投资者更是如此。其实换位思考一下就不难理解，作为主力，在已经选好了相关的目标标的的前提下，接下来要做的是什么？毫无疑问就是寻找合适的买点，力争在有吸引力的价位上建立仓位，这个有吸引力的价位就是主力资金考虑的重点。怎样才能找到有吸引力的价位？主要从以下两方面来考虑，一方面从公司的价值来考虑，即当下价格与内在价值水平情况；另一方面从当下市场环境和本身技术面来考虑。总体来说，在重点考虑上述原则后，要做到在别人贪婪的时候感到恐惧，在别人恐惧的时候懂得贪婪。</p><h3 class=\"listHeadline\"><a id=\"c1\"></a>一、无人问津处，潜流在暗涌</h3><p class=\"bodyContent\">“无人问津”其实很大程度上就是市场极度恐慌或绝望的表现，市场达到无人问津的程度时，市场情绪往往接近冰点，此时一般都是大跌或大跌后的低迷整理期，此时市场失去了赚钱效应，或更多地处于深度套牢的状态无法动弹，甚至时间久了达到不屑去理会的程度，从而造成了市场一潭死水的局面。然而表面上看起来一潭死水的市场，其内在真的如此吗？对于大众来说，眼见为实，能够看到的东西确实是最有说服力的，下意识中我们很有可能就把摆在眼前的现象深深地印入了脑海，植入了内心深处，从而不约而同地认为市场果然如此。这是绝大部分投资者的正常思维模式，但事实真的如此吗？表面现象真的是内在本质的真实反映吗，要果真如此，为何大部分人的观点都是错误的呢？市场为何总是逆大众心理而为呢？要是大部分人的看法是对的，市场上为何大部分人不能够盈利，而总是只有极少的人能够盈利呢？</p><p class=\"bodyContent\">残酷的结果表明，表面现象很大程度上并不是内在市场规律的真实反映，可以说更多的是一种假象或至少不能真实反映内在，为何会如此呢？其实从博弈的角度来看，你会很容易找到问题的答案。很多投资者或许从来没有想过博弈这个问题，众所周知，股票市场有很大的煽风效应，很多投资者之所以入市，是由于受到别人的影响或看到别人很容易就赚到了钱，只看到了光鲜的一面，而没有看到残酷的一面，就像捡了宝似的冲了进来。至于为何看不到残酷的一面，这是因为人性本是如此，谁都是尽量把自身成功的一面示人，与别人分享成功的喜悦，尤其是当在市场上尝到一点甜头时，就迫不及待地向别人讲述成功的经过，而当出现亏损的时候却只字不提，当作没有这回事，不会迫不及待地告诉他人自己失败的经历。这也就是为何刚进来的投资者都拥有美好的愿景和十足的信心，只有自己亲身经历了失败才知道原来不是这么简单，市场表面光鲜诱人内在却布满了荆棘，就像前面我们分析过的表面看起来无人问津时的市场，其内在并不会像我们看到的那样简单的道理一样。不光是刚入市的投资者会这样，入市后大部分投资者也依然无法在此起彼伏的市场中认清现象的本质，更多的是看到“涨”这个现象就认为股价要上涨了，然后采取买进的策略，看到跌了就认为市场要跌了，便采取卖出的策略，也就是所谓的追涨杀跌，按自己的情绪行事，博弈（包括心理面、资金面等）之类的可能想都没有想过，这是市场常见现象。而对于主力资金而言，则不得不考虑博弈，而且要善于运用博弈来达到自身运作的目的。上述所说的为何市场表象很大程度上并不是市场内在本质的真实反映，除了受自身先入为主的思想影响外（看到市场的这种现象并认为事实本身就是如此），最主要的原因还在于主力资金运作的相对隐蔽性。表面上的无人问津处，其实暗流在涌动，如果投资者按照这个表面现象得出看起来符合逻辑的预判，结果经常会使人失望。</p><p class=\"bodyContent\">“无人问津处，暗流在涌动”，很大程度上就是“人弃我取、人取我弃”的思路，这是主力惯用思路，也是主力资金选取适宜买点的绝好机会。不知投资者有没有听到过这样一则故事，曾经有个和尚，他不懂得什么技术面、基本面，也不懂得经济分析，他却成为了资本市场的佼佼者，进入了为数不多的能在市场中盈利之行列，就有人大惑不解：为何自己整天用心研究却得不到应有的回报，局外人却能够获利颇丰？于是他前去请教和尚，当问及其为何能够成功时，和尚回答道:“我确实不怎么懂得市场的运行规律，也不会预测接下来将会发生什么，但我看到大家都抛弃手中的股票时，我佛慈悲，我就尽自己所能买下了，而当大家挤破头蜂拥而至时，我佛慈悲，我就卖给他们了，结果就成了现在这个样子了。”不管这个故事是真是假，我想它告诉了我们人取我弃、人弃我取的深刻道理；同时也告诉我们：资本市场并不是努力就有回报的（当然不努力是肯定得不到回报的），如果只知道一味地努力而没有正确的思想指导，即对市场本质没有应有的理解，我想再怎么努力也无济于事。这个故事告诉投资者：看似无人问津处的市场，很有可能本质上并非如此，暗流涌动，将要起波澜或许才是其本质。市场上流传的一个生动而形象的例子可以很好地说明这一点。相信大家都有这样的经历，刚开始煮开水的时候，水面非常之平静，几乎看不到什么动静，而水下面其实已经在起波澜，而当水面沸腾的时候，这壶水就快要烧开了。事物的发展规律是相同的，市场的运行又何尝不是如此，表面上无人问津的时候，很有可能暗流在涌动，重心在曲折中慢慢地抬高了，等真的有大的动作进入亢奋时很有可能就是这波行情阶段性要告一段落的时候了。这也是为什么行情总是在极度恐慌时发生转机，在谨慎时推进、在疯狂中结束的原因。</p><h3 class=\"listHeadline\"><a id=\"c2\"></a>二、价值体现前，勇敢去潜伏</h3><p class=\"bodyContent\">评估公司当下的价值和市场价格是主力建仓前行动的重要一环，也是标的选择的重要一环。选择当下被低估的品种，即选择市场价格低于本身价值的品种，或未来将有重大事件使其本身价值发生巨变的有潜力的品种，例如不少知名基金经理喜欢挖掘一些未来具有重组、资产注入、收购等潜力的品种，往往这些事件能够短时间内使公司的价值发生巨大的变化，表现在股价上也就很容易起大的波澜。对于机构投资者而言，他们会有一套适合自身的有效的价值评估体系，经过自上而下、自下而上或两者结合精选出符合系统标准的目标标的。所谓自上而下，就是首先研究宏观经济，然后选择受益于宏观经济发展趋势的行业，然后再从这些行业中选择好的公司；所谓自下而上，则是直接切入个股，采用这种策略更多关注个别公司的成长空间、管理能力、业务模式、估值等等。当然主力资金通常都会结合两者，综合研判，筛选出符合标准的相关标的。</p><p class=\"bodyContent\">对于投资者而言，要对上述大道理都有一定的了解，但是，了解了上述道理也只知大概，具体主力资金是如何评估上市公司的价值而筛选出目标标的，才是投资者需要知晓的重点，不然最终还是无法领悟其中真谛。我们都知道机构资金常常都是用建立数学模型、设置参数等手段估算公司的内在价值，而对于大多数投资者而言，繁琐的计算根本不是他们的兴趣所在，甚至感到棘手，这很正常。术业有专攻，我们不是数学家，不必按照这个形式去估算上市公司的内在价值，我们只需要根据其中的逻辑来思考公司的内在价值。我们要做的是通过衡量内在价值与市场价值之间的“差”来确定安全边际，并通过不断释放内在价值来获取收益。对于内在价值，巴菲特给出了经典的定义：企业未来创造现金流的折现。对于怎样的企业才是好的企业，以及哪些企业可以作为我们的目标标的，这个问题在本丛书之《主力选股策略》中有一些思路的阐述，有兴趣的读者可以读一读，在这里我们总体来说一下好的企业必须符合的条件，即筛选目标标的的条件。</p><p class=\"bodyContent\">第一，企业经营的存续期足够长，当前现金创造能力再强，如果不能持续也不可能长久生存；</p><p class=\"bodyContent\">第二，企业在存续期内的经营成果，以赚取并保留了大量现金为标志，否则即使存在了100年，每年赚的钱都要投入到下一年的扩张或者经营必需的现金支出里，最终留在手上的其实所剩无几；</p><p class=\"bodyContent\">第三，对于企业的上述预期必须辅以较高的确定性因素支持，不确定因素太多，将会对最终的结果产生过大的不确定性影响。</p><p class=\"bodyContent\">符合上述三个基本条件的上市公司可以作为我们的参考标的。解释一个企业内在价值的大体框架基本确立后，符合这个大体框架的上市公司便具有一定的投资价值，当然这只是开始，接下来我们需要做的是在此基础上进一步扩充与深度挖掘。存续期方面，包括企业所处行业的空间与稳定性，企业外部需求的持续性，企业面临的经营环境，企业在此行业中的相对低位和当前的绝对规模，等等。现金积累方面，包括企业的扩张边际成本如何，固定资产占比如何，为了维持必要经营的现金耗费占利润比如何，生意属性上是赊货拿钱还是相反，行业的供需结构对企业盈利的影响，等等。</p><p class=\"bodyContent\">确定性方面，包括企业的竞争优势是否牢靠，企业的治理结构是否健康，企业的发展战略是否正确且可执行，企业的过往经营历史如何，等等。在进一步分析如“企业所处的行业空间与稳定性”中，我们可以分析该行业的前景，即未来发展空间大不大，是处于朝阳期、成熟期，还是正处于衰退期；整个行业的产业链如何，该行业是处于该产业链中的哪个位置，是上游、中游，还是下游等。稳定性方面我们可以分析这个行业在国民经济中的地位如何，是不可或缺的一部分还是可替代的一部分，等等。进一步深度挖掘所有问题后，公司内在价值几何，每个人心中都会浮现一个大体的判断，至少不会像之前那样迷茫。总之，只有进一步深度挖掘，对企业进行评估，才有可能真正了解公司的内在价值，鉴定是不是具备投资的价值。完成初步的选择和深度的挖掘后，对于不懂得具体数学模型计算的投资者来说，至少有底气和信心了，知其然、知其所以然后，再看看公司当下的价格水平，结合当下的PE（市盈率）等估值标准，就很容易判断当下是不是一个适宜的买点。</p><p class=\"bodyContent\">当然这个过程是复杂的，而且真正地深度挖掘进去后，绝对是一个不小的工程，虽然不用设定一系列参数和代入公式去进行复杂的计算，但也需要一点一点去分析，理清其中的思路，对这个行业和公司有深入的了解。看到这些，也许不少投资者感到害怕了，要知道，现实总是如此残酷，天下没有免费的午餐，投资也不例外，也是一个苦行僧的活儿，没有一点一滴的付出，要想一步登天，只能是黄粱美梦，俗话说：不积跬步，无以至千里。</p><p class=\"bodyContent\">经过系统的分析，完成对公司价值体系的评估后，接下来我们要做的就是在价值体现前勇于去潜伏。懂得潜伏、耐心持股也是获取最终胜利至关重要的一环。挖掘价值是一方面，耐心等待价值的实现又是另一方面，只有两者结合起来才能获得好的成果。</p><p class=\"bodyContent\">在现实投资中，相信来到市场中的每一个人都有过类似的经历，很多时候并不是我们没有买到牛股，而是在价值体现前最黑暗的时候被颠下了马，或是在价值刚刚体现初期由于短视而错过了真正的主升浪。当然这很大程度上是由于没有深刻了解股票运行（上涨或下跌）的规律所造成的，同时也是市场浮躁心理导致的。整天想着买进去就涨，或短时间内能够获得大利，这种没有耐心、禁不住时间考验的投资心理，正是获取利润的大忌，十有八九会导致失败。投资本是一个长期和曲折的过程，逆市场规律而行，最终的结果将是得到应有的惩罚。然而有人可能会打破砂锅问到底：为何说投资是一个长期和曲折的过程？问得好，对于投资来说就是要深刻地理解市场本质的东西，理顺其中的逻辑才有可能走得更远。本书后面章节将会重点讲述其中缘由，在此不做详细的讲述。总之，记住，要懂得潜伏，耐心持股，直到价值的实现。</p><h3 class=\"listHeadline\"><a id=\"c3\"></a>三、时间与空间的权衡</h3><p class=\"bodyContent\">理解建仓时主力对时间和空间的权衡，需要深刻理解市场为何总是在悲观绝望时诞生机会，在突破前夕出现折磨人的走势。对于大部分人而言，可能对这些现象早已耳闻，但在这里我想说的是，知道并不等于就有深刻的了解，而且问题往往就出在知道却没有深刻了解的时候。</p><p class=\"bodyContent\">很多人可能会问，这有什么区别呢？不但有区别而且区别很大。知道很有可能就只是停留在表面上，别人提起就想起来，没人提起就很有可能毫无印象，其实这与不知道没有什么区别；而深刻了解则是植入脑海中深深的记忆，我们要的就是这种状态。</p><p class=\"bodyContent\">为何我们需要的是深刻体会，而不只是知道呢？这与资本市场的特性有大的关系，这是一个时刻充满着诱惑和恐惧的市场，很容易使人失去理智，请问，在这个浮躁的、时刻可能使人失去理性的市场，停留在表面上的记忆能够发挥作用吗？平时你可能都想不起来，在非理智或情绪受干扰的情况下就更不用说了。只有深刻理解后深深植入脑海深处的东西，才有可能在非理智的情况下迸发出火花来，抑制住非理性的行为。所以说，对市场的看法或一些思路上的东西一定不能停留在表层，而要深层次地理解。</p><p class=\"bodyContent\">我们再来看看现象背后的本质。首先我们来想一想什么样的价位具有吸引力。对于主力资金而言，要想获得上涨的空间，无疑只有两种途径，一是在原有基础上继续上涨，带来绝对向上空间；二是在现有基础上跌出来的空间。进一步研究，在原有基础上继续上涨带来的绝对向上空间是可以带来获利空间的，但如果该股的价位原本就处于相对高位，作为主力资金会不会觉得当下价格有点高呢？在高的基础上要想继续向上拓展空间也是可以做到的，但运作成本是不是过高呢？而且考虑一下风险，要是下跌呢？所以，综合来看，当价格本来处于相对高位时，进一步向上拓展空间运作成本较大且空间也较为有限，同时，风险也相对较大。对主力资金而言，这种途径无疑不会很有诱惑力，除非短期内公司有可能出现重大利好使其基本面的价值出现突变，否则不会轻易出手。当然这也不是绝对的，市场中也是存在强者恒强现象的。</p><p class=\"bodyContent\">我们再来看看第二种途径，即在跌出来的空间寻找机会。一来经过下跌后，最好是大跌，短期风险得到了很大程度的释放；二来，跌出的空间可以成为接下来获利的空间，也就是后市获利的空间将更大。总体来说，这一途径更安全，获利空间也更大，无疑对于主力资金而言更具诱惑力，更靠近于主力资金会考虑采取的建仓策略。看到这里，相信大部分投资者对为何行情总是在绝望的时候发生转机有了更深刻的理解，原因就在于，绝望的时候往往就是行情处于大幅下跌中后期极度低迷或泥沙俱下的恐慌阶段，此时对于主力资金而言，正是收集廉价筹码的极好时机，当然前提是大的格局依旧向好。其实这也验证了前面所提及的一个重要思路：无人问津处，暗流在涌动。市场泥沙俱下并不一定就是坏事，很有可能接下来酝酿的是物极必反的趋势，通过表面现象看到本质才是赢之道。建仓时的空间也是一个极其重要的因素，这里的空间是主力资金建立底仓的价格范围，即吸纳筹码的区域，主力在这个空间内完成对筹码的收集。理解空间的概念后，相信大家对为何市场在真正启动前夕总会出现反复折磨人的走势有了更为深刻的了解，这主要有以下两方面的原因：一方面在主力未完成筹码的吸纳任务之前，一般都会使股价重新回到上述所说的建仓空间之内；另一方面，主力要想在此空间内获得需要的筹码必须不断地反复，制造折磨人的走势，才能使市场交出筹码，从而收集所需要的筹码，完成底仓的建立。看清现象背后的本质，才能使我们在此起彼伏的市场中获得最后的胜利。</p><p class=\"bodyContent\">巴菲特曾经说过：短期来说市场是投票机，长期而言是称重机。也就是说，对于短期而言，市场千变万化，受市场情绪变化的影响较大，不可预期和不确定性因素太多，虽然可以找到一些规律，但不可能长期精确，这也是为何喜欢频繁操作短线的投资者很难从市场中长期盈利，而更多的是亏损的原因。这是现实，也是市场中常见的一种现象。每天一股脑地扎在市场中拼命厮杀跟随市场起舞，最终还是费力不讨好，被市场折磨得不成样子。主力建仓时要的就是一个折磨人的效果，懂得这一本质的投资者，面对市场的波动至少会多一份淡定和从容，而不至于每次股价一骑绝尘之前就被颠下马。</p><p class=\"bodyContent\">探讨完主力建仓时对时间和空间的权衡后，相信投资者对市场的本质已有了更深刻的了解。最终产生的效果如何，就看能否转化为实际行动了。还是那句话：有些东西知道了并不一定能发生作用，行动才是迈向成功的关键。</p><h3 class=\"listHeadline\"><a id=\"c4\"></a>四、操盘手记</h3><p class=\"bodyContent\">适应孤独、超越极限才能创造奇迹</p><p class=\"bodyContent\">甲：你不是说要奋笔疾书吗？怎么我看你发呆或走来走去有段时间啦，一点也不见你有奋笔的意思呀？没思路，还是别的什么原因？乙：什么原因都有，反正现在我的状态不是很好，不知为何一坐下来就总想休息。其实我也不想这样，我很想奋笔疾书，但是……你说没思路吧，其实思路还挺多的，可能无从下笔吧。</p><p class=\"bodyContent\">甲：感觉得出你有点烦躁，或者说你没静下心来。我知道你是个追求完美的人，你也是个没有压力就没动力的人，一旦感觉不在最佳状态或没有太多压力的时候，你内在的懒惰之心就可能占据了主导地位。</p><p class=\"bodyContent\">乙：被你说中了！</p><p class=\"bodyContent\">甲：呵呵，你现在要做的就是看看你墙上写的那些字：“超越极限才能创造奇迹”，要做不可能完成的事情，这样你的信心才有可能坚定呀。乙：嗯，看到这些字，我感觉好多了。只是，意志总有不坚定的时候，尤其是在周末，哎，本来可以好好奋笔疾书的，可总是有这样或那样的事让我分心呀。甲：所以你要更珍惜每一分每一秒。其实你对自己要写的东西已经有提纲了，但计划很多时候是赶不上变化的，一旦变化过大，你的计划就有可能夭折。在没有大变化前，如果你加紧计划的进度，那么，一旦有些变化也不足以影响整个大局。再说了，只有超越极限才能创造奇迹，这点你应该比我清楚，你的极限还远远没到，更谈不上超越了。呵呵，你接下来要做的事情可多啦，现在我非常支持你奋笔疾书，虽然我也很想和你出去喝喝茶，但我更想看到你奋笔疾书的样子。乙：我知道了，听你这么说，感觉好多了。真的，我对未来充满了信心。最重要的是，现在我充满了能量，足以奋笔疾书了。</p><p class=\"bodyContent\">甲：哈哈，那就好嘛。不多打扰了，我找你徒弟出去喝茶咯。乙：行，呵呵，他们求之不得呢。</p><p class=\"bodyContent\">甲：只有经历了孤独才会有真正的质变，我已看到了你新的未来啦。做任何事都要有坚定的目标，很多时候，不是做不了，而是你太懒惰。人性的弱点之一就是懒惰，懒惰总是在你稍微松懈的时候乘虚而入，所以，你要不时地提醒自己什么才是最重要的，坚定自己的信念，只有这样才能让自己充满能量，去面对一切具有挑战性的工作。</p><p class=\"bodyContent\">超越极限才能创造奇迹，这是一种态度，一种信念，更是一种真理。人只有经历了孤独，才具备质变的基础，人需要不断在孤独中寻找自我。如果你实在忍受不了孤独，不妨好好跟自己对对话，这也是一种让你适应孤独的方式。</p><p class=\"bodyContent\">通宵奋战有感</p><p class=\"bodyContent\">甲：听说昨晚你通宵啦？</p><p class=\"bodyContent\">乙：是的，通宵看书。</p><p class=\"bodyContent\">甲：效果如何？</p><p class=\"bodyContent\">乙：挺好的，饿了就吃困了就打个盹无聊就看看动漫或新闻，事实上，真正看书的时间并不多，不过，至少整晚都在思考书籍的内容，尤其是在深夜，很容易思考到关键点上，迸发出精彩的火花来。</p><p class=\"bodyContent\">甲：看来收获不小嘛。只是要注意身体，这种情况可不能成为常态。乙：嗯，就好像旧社会肉尤为珍贵一样，每月只能吃一次或每年也就吃那么几次而已。我通宵的次数也跟过去的肉一样稀少。</p><p class=\"bodyContent\">甲：呵呵，千万别跟你现在吃肉的频率一样就好。</p><p class=\"bodyContent\">乙：昨天通宵的过程中，我不经意看到了一些关于童话大王郑渊洁的故事，他的书我很小的时候就曾迷过，他是我很欣赏的一个人。他的坚持与个性成就了他今天的成绩，这点让我感受颇深，未来，我要做的或许就是金融文化的郑渊洁。甲：是呀，就看你够不够勤奋了，如果你也能做到像郑渊洁那样每个月写出一本杂志的话，中国金融文化的丰富与发展就有戏了。</p><p class=\"bodyContent\">乙：我所期望的是每个月写一本书，我想进化。</p><p class=\"bodyContent\">甲：只要你想，我觉得对你来说并不是问题。我很能说，但我深知写作方面远不如你，你一旦文思如泉涌，很容易就能写出一篇精彩的文章。而我下笔就不知道该写什么，至少打字就不如你快，节奏各方面都很难跟上，所以，写作这东西呀，还真是要有点天赋才行。</p><p class=\"bodyContent\">乙：呵呵，熟能生巧，你只是不习惯而已，你不习惯把自己的思想写出来，你习惯口头表达出来而已。</p><p class=\"bodyContent\">甲：是呀，加油吧。未来世界很广阔呢！</p><p class=\"bodyContent\">乙：我已经看到了，所以，我必须开始体验通宵奋战，这是为未来所做的必要准备。我很喜欢这样的感觉。</p><p class=\"bodyContent\">甲：对了，通宵奋战后第一件事情是干什么呢？</p><p class=\"bodyContent\">乙：洗澡，然后好好睡一觉。</p><p class=\"bodyContent\">甲：呵呵，其实，本质上，至少从你每天的时间分配上来说，结果还是差不多的，你说呢？只是，你把一些本来应该白天做的事情安排到了深夜中完成了。乙：哈哈，没错，不过换种方式来安排一天，虽然本质一样，效果却是截然不同的。</p><p class=\"bodyContent\">甲：对，人就是喜欢这样，在一样的结果中去寻找不一样的体验过程。通宵奋战为的是什么？为的是更美好的未来。</p><p class=\"bodyContent\">这过程本身就很让人受鼓舞，因此，当你面对一些重大事情需要处理的时候，不妨借助通宵奋战这种方式来激励与鼓舞自己。正如上面对话最后谈到的那样，虽然本质跟不通宵奋战是一样的，但换个方式来安排时间其效果是截然不同的。我们需要多点这样的体验，只有这样，我们的生活与工作才更精彩。</p><p><br/></p><!--!doctype--><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p>\t\t\t</p>";
        String content2 = "<p>\t\t\t\t\t\t\t\t\t\t\t</p><style type=\"text/css\">@charset \"utf-8\";\n" +
                "/* CSS Document */\n" +
                ".frontCover {\n" +
                "\ttext-align:center;\n" +
                "\tborder:0;\n" +
                "}/*封皮*/\n" +
                "a {\n" +
                "\ttext-decoration:none;\n" +
                "}\n" +
                "h1.Sequence, h1.chapterCaption {\n" +
                "\tfont-family:'';\n" +
                "\tfont-size: 1.05em;\n" +
                "\tline-height: 1.5em;\n" +
                "\ttext-align: left;\n" +
                "\ttext-indent:0;\n" +
                "\tcolor:#c36500;\n" +
                "\tmargin:5pt 0;\n" +
                "\tletter-spacing:auto;\n" +
                "}   /*一级标题*/\n" +
                "h2.sectionHeading {\n" +
                "\tfont-family:'';\n" +
                "\tfont-size: 1.0em;\n" +
                "\tline-height: 1.5em;\n" +
                "\ttext-align: center;\n" +
                "\ttext-indent:0;\n" +
                "\tcolor:#c36500;\n" +
                "\tmargin:5pt 0;\n" +
                "\tletter-spacing:auto;\n" +
                "} /*二级标题*/\n" +
                "h3.listHeadline {\n" +
                "\tfont-family:'';\n" +
                "\tfont-size: 0.95em;\n" +
                "\tline-height: 1.5em;\n" +
                "\ttext-align: left;\n" +
                "\ttext-indent:0;\n" +
                "\tcolor:#7a3c00;\n" +
                "\tmargin:5pt 0;\n" +
                "\tletter-spacing:auto;\n" +
                "} /*三级标题*/\n" +
                "h4.lastTitle {\n" +
                "\tfont-family:'';\n" +
                "\tfont-size: 0.9em;\n" +
                "\tline-height: 1.3em;\n" +
                "\ttext-align: left;\n" +
                "\tcolor:#7a3c00;\n" +
                "\ttext-indent:0;\n" +
                "\tmargin:5pt 0;\n" +
                "\tletter-spacing:auto;\n" +
                "} /*四级标题*/\n" +
                "h5.fiveTitle {\n" +
                "\tfont-family:'';\n" +
                "\tfont-size: 0.85em;\n" +
                "\tline-height: 1.3em;\n" +
                "\ttext-align: left;\n" +
                "\ttext-indent:0;\n" +
                "\tmargin:3pt 0;\n" +
                "\tletter-spacing:auto;\n" +
                "} /*五级标题*/\n" +
                "h6.sixTitle {\n" +
                "\tfont-family:'';\n" +
                "\tfont-size: 0.85em;\n" +
                "\tline-height: 1.3em;\n" +
                "\ttext-align: left;\n" +
                "\ttext-indent:0;\n" +
                "\tmargin:3pt 0;\n" +
                "\tletter-spacing:auto;\n" +
                "} /*六级标题*/\n" +
                ".bodyContent {\n" +
                "\tfont-family:'';\n" +
                "\tfont-size: 0.85em;\n" +
                "\tline-height: 1.5em;\n" +
                "\ttext-align:left;\n" +
                "\ttext-indent: 2em;\n" +
                "\tmargin:10pt 0;\n" +
                "\tletter-spacing:auto;\n" +
                "} /*正文内容*/\n" +
                ".notNaturalParagraph{\n" +
                "\tfont-family:'';\n" +
                "\tfont-size: 0.85em;\n" +
                "\tline-height: 1.5em;\n" +
                "\ttext-align:left;\n" +
                "\ttext-indent: 2em;\n" +
                "\tmargin:0;\n" +
                "\tletter-spacing:auto;\n" +
                "}/*非自然段落*/\n" +
                ".dyfirst{\t\n" +
                "\tfont-family:'';\n" +
                "\tfont-size: 0.85em;\n" +
                "\tline-height: 1.5em;\n" +
                "\ttext-align:left;\t\n" +
                "\tmargin:10pt 0;\n" +
                "\tletter-spacing:auto;\n" +
                "}\n" +
                ".dyfirstLetter{\n" +
                "\tfloat: left;\n" +
                "\tfont-size: 280%;\n" +
                "\tfont-weight:bold;\n" +
                "\tcolor:#c36500;\n" +
                "\tline-height: 1;    \n" +
                "\ttext-transform: uppercase;\n" +
                "}/*首行文字下沉效果*/\n" +
                ".fnoteRight {\n" +
                "\tfont-family:'';\n" +
                "\tfont-size: 0.8em;\n" +
                "\tline-height: 1.5em;\n" +
                "\ttext-align:right;\n" +
                "\tletter-spacing:auto;\n" +
                "} /*右下角说明*/\n" +
                ".bodyReference {\n" +
                "\tfont-family:'';\n" +
                "\tfont-size:0.85em;\n" +
                "\ttext-align:left;\n" +
                "\ttext-indent:2.0em;\n" +
                "\tline-height: 1.5em;\n" +
                "\tletter-spacing:auto;\n" +
                "} /*书信称谓*/\n" +
                ".bodyLetter{\n" +
                "\tfont-family:'';\n" +
                "\tfont-size:0.75em;\n" +
                "\ttext-align:left;\n" +
                "\ttext-indent:2.0em;\n" +
                "\tline-height: 1.5em;\n" +
                "\tletter-spacing:auto;\n" +
                "\tfont-style:italic;\n" +
                "}/*书信内容*/\n" +
                ".titleQuot {\n" +
                "\tfont-family:'';\n" +
                "\tfont-size: 0.8em;\n" +
                "\tline-height: 1.5em;\n" +
                "\ttext-align:left;\n" +
                "\ttext-indent: 24px;\n" +
                "\tmargin:5pt 0;\n" +
                "\tletter-spacing:auto;\n" +
                "}/*引文标题*/\n" +
                ".conQuot {\n" +
                "\tfont-family:'';\n" +
                "\tfont-size: 0.75em;\n" +
                "\tline-height: 1.5em;\n" +
                "\ttext-align:left;\n" +
                "\ttext-indent: 48px;\n" +
                "\tmargin:5pt 0;\n" +
                "\tletter-spacing:auto;\n" +
                "}/*引文*/\n" +
                ".bodyPic {\n" +
                "\ttext-align:center;\n" +
                "\tfont-size:0%;\n" +
                "} /*正文图表*/\n" +
                ".imgDescript {\n" +
                "\tfont-family:'';\n" +
                "\tfont-size:0.7em;\n" +
                "\tline-height:1.5em;\n" +
                "\ttext-align:center;\n" +
                "\ttext-indent:0;\n" +
                "\tcolor:#a25400;\n" +
                "\tletter-spacing:auto;\n" +
                "} /*图表注释*/\n" +
                ".tableCaption{\n" +
                "    font-family:'';\n" +
                "\tfont-size:0.85em;\n" +
                "\tline-height:1.5em;\n" +
                "\ttext-align:center;\n" +
                "\ttext-indent:0;\n" +
                "\tcolor:#a25400;\n" +
                "\tletter-spacing:auto;\n" +
                "}/*正文中表格表头样式*/\n" +
                ".borderColor{\n" +
                "   border:2px solid #a25400;\n" +
                "}/*边框样式*/\n" +
                ".bgroundColor{\n" +
                "   background:#F8F2DA;\n" +
                "}/*段落底色*/\n" +
                ".signImg {\n" +
                "\ttext-align:right;\n" +
                "\tfont-size:0%;\n" +
                "}/*正文右下角签名图片*/\n" +
                ".noteTitle {\n" +
                "\tfont-family:'';\n" +
                "\tfont-size:0.8em;\n" +
                "\tline-height:1.5em;\n" +
                "\tfont-weight:bold;\n" +
                "\ttext-align:left;\n" +
                "\ttext-indent:0;\n" +
                "\tletter-spacing:auto;\n" +
                "} /*附注*/\n" +
                ".noteContent {\n" +
                "\tfont-family:'';\n" +
                "\tfont-size:0.6em;\n" +
                "\tline-height:1.5em;\n" +
                "\ttext-align:left;\n" +
                "\ttext-indent:2em;\n" +
                "\tletter-spacing:auto;\n" +
                "} /*附注说明*/\n" +
                ".bodyPoem {\n" +
                "\tfont-family:'';\n" +
                "\tfont-size:1.0em;\n" +
                "\ttext-align:center;\n" +
                "\tline-height:1.5em;\n" +
                "\tletter-spacing:auto;\n" +
                "} /*诗词*/\n" +
                ".conAuthor {\n" +
                "\tfont-family:'';\n" +
                "\tfont-size:0.9em;\n" +
                "\ttext-align:right;\n" +
                "\tline-height:1.5em;\n" +
                "\tpadding-right:4em;\n" +
                "\tletter-spacing:auto;\n" +
                "} /*诗词作者*/\n" +
                ".poemText {\n" +
                "\tfont-family:'';\n" +
                "\tfont-size:0.8em;\n" +
                "\ttext-align:center;\n" +
                "\tline-height:1.5em;\n" +
                "\tletter-spacing:auto;\n" +
                "} /*诗词正文*/\n" +
                "span.super {\n" +
                "\tfont-size:0.7em;\n" +
                "\tvertical-align: super;\n" +
                "} /*数字上标*/\n" +
                "span.sub {\n" +
                "\tfont-size:0.7em;\n" +
                "\tvertical-align: sub;\n" +
                "} /*数字下标*/\n" +
                "span.subScript {\n" +
                "\tfont-size:0.7em;\n" +
                "\tvertical-align: super;\n" +
                "}/*跳转注标*/\n" +
                ".bold {\n" +
                "\tfont-weight:bold;\n" +
                "}/*加粗*/\n" +
                ".left {\n" +
                "\ttext-align:left;\n" +
                "\ttext-indent:0;\n" +
                "}/*左对齐*/\n" +
                ".center {\n" +
                "\ttext-align:center;\n" +
                "\ttext-indent:0;\n" +
                "}/*居中对齐*/\n" +
                ".right {\n" +
                "\ttext-align:right;\n" +
                "\ttext-indent:0;\n" +
                "}/*右对齐*/\n" +
                ".indentS {\n" +
                "\ttext-indent:2em;\n" +
                "\tmargin:5pt 0;\n" +
                "}/*其它缩进24像素*/\n" +
                ".indentT {\n" +
                "\ttext-indent:3em;\n" +
                "\tmargin:5pt 0;\n" +
                "}/*其它缩进36像素*/\n" +
                ".indentF {\n" +
                "\ttext-indent:4em;\n" +
                "\tmargin:5pt 0;\n" +
                "}/*其它缩进48像素*/\n" +
                ".emphasis {\n" +
                "\ttext-decoration:underline;\n" +
                "}/*着重强调加下划线*/\n" +
                ".textItalic {\n" +
                "\tfont-style:italic;\n" +
                "}/*斜体*/\n" +
                ".conLink {\n" +
                "}/*正文中网址*/\n" +
                ".rareFont {\n" +
                "\twidth:0.8em;\n" +
                "}/*正文中生僻字图片代替*/\n" +
                ".subHead {\n" +
                "\ttext-align:right;\n" +
                "}/*副标题*/</style><h2 class=\"sectionHeading\"><span style=\"FONT-SIZE: 18px\">浙江 乌镇</span></h2><blockquote><h3 class=\"listHeadline\"><a id=\"c005\"></a>雨巷、油纸伞、带着愁怨的姑娘，小桥、流水、炊烟袅袅的水镇人家，乌镇，就像一幅意境悠远的淡淡的水墨画。</h3></blockquote><p class=\"bodyContent center\"><img alt=\"\" src=\"http://10.255.242.6:8300/imgother10/82/23/1900101538_image16-1.jpg\" width=\"100%\"/></p><p style=\"TEXT-INDENT: 2em\">乌镇地处浙江省桐乡市北端。据说很久以前，小镇的墙上都刷着一种黑色的油漆，而桐乡一带又常把“黑”叫做“乌”，后来人们就把这个玲珑的水镇叫“乌镇”了。</p><p style=\"TEXT-INDENT: 2em\">桥，自然是水乡不可或缺的部分。据记载，康熙年间，乌镇有上百座桥。它们就像是点缀在美人裙裾间的丝丝飘带，闪烁动人；又像历尽沧桑的垂垂老者，安静地守护着水乡的岁月轮回。多少年来，只有这淙淙的流水，耐心地聆听，日夜地吟诵着那些桥的历史和传说。桥与桥相连，影和影交错。</p><p style=\"TEXT-INDENT: 2em\">在桥和影互相交错的水乡，还有一种独具特色的建筑——水阁。事实上，水阁本与浪漫的心境无关，它是乌镇民居伸长的“阳台”。乌镇的民居大都沿河而建，而且房屋的一部分延伸到河面上方，底部用木桩或石柱打在河床中作为支撑，上架横梁，再搁上木板，就形成了突出在水面上的“阳台”。有了水阁，人们就可以站在自家后门用吊桶打水；可以在梦醒后聆听船桨划过声；可以在清晨轻推雕花木窗，迎接扑面的清风；可以遥看头裹蓝色印花头巾的船娘不徐不疾而过。这时，你便真正体味了水乡“人家尽枕河”的滋味。</p><p style=\"TEXT-INDENT: 2em\">然而，乌镇的生活并不止这些。在桥和水阁之外，茶馆是乌镇生活的一个万花筒。在这里，只需一盏茶的工夫，上至国家重大政策，下至小孩调皮捣蛋，你都能了解得到。乌镇大大小小的茶馆散落在各个街巷的水阁里，或宽敞雅致或质朴简单，却都能让你品出水乡的原汁原味。傍晚时分，寻一处茶馆，依窗而坐，一面傍河，一面临街，街道喧哗，河道沉寂，将是一件多么难得、多么惬意的事啊。</p><p style=\"TEXT-INDENT: 2em\">如此美丽的小镇，也许让人不忍打扰。但是，当城市喧嚣繁华，当孤独无法排解，停下来吧，把心流放。你的花样年华里也将有如水的宁静，如歌的浪漫，如画的纯美，如梦的奇幻。</p><p class=\"bodyContent center\"><img alt=\"\" src=\"http://10.255.242.6:8300/imgother10/82/23/1900101538_image17-1.jpg\" width=\"100%\"/></p><p class=\"imgDescript\">LOOK 乌镇东街。虽然有些老旧，但一弯河道却过滤了诸多杂质，流出无限的悠然韵致。</p><p>\t\t\t</p>";

        int count1 = StringTimes.findStr1(content2,"<img");
        int count2 = StringTimes.findStr2(content2,"<img");
        int count3 = StringTimes.findStr2(content2,"<img");
        List<String> imgList = StringTimes.getArtileImgList(content2);
        System.out.println("出现次数"+count1+"--"+count2+"--"+count3);

            List<String> barVoList = new ArrayList<String>();
            System.out.println("3333"+barVoList.size());
            barVoList.add("1");
            barVoList.add("1");
            barVoList.add("1");
            barVoList.add("1");
    }
}
