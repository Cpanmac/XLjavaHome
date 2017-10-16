package com.xuan.xutils.utils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * Æ´Òô¹¤¾ßÀà
 *
 * @author xuan
 * @version $Revision: 1.0 $, $Date: 2012-11-22 ÉÏÎç9:56:17 $
 */
public abstract class SpellUtils {
    public final static HashMap<String, String> surnameMap = new HashMap<String, String>(415);
    private final static LinkedHashMap<String, Integer> spellMap = new LinkedHashMap<String, Integer>(400);
    ;

    static {
        initialize();
    }
    private static void spellPut(String spell, int ascii) {
        spellMap.put(spell, ascii);
    }

    private static void surnamePut(String surname, String firstSpell) {
        surnameMap.put(surname, firstSpell);
    }

    private static void initialize() {
        spellPut("a", -20319);
        spellPut("ai", -20317);
        spellPut("an", -20304);
        spellPut("ang", -20295);
        spellPut("ao", -20292);
        spellPut("ba", -20283);
        spellPut("bai", -20265);
        spellPut("ban", -20257);
        spellPut("bang", -20242);
        spellPut("bao", -20230);
        spellPut("bei", -20051);
        spellPut("ben", -20036);
        spellPut("beng", -20032);
        spellPut("bi", -20026);
        spellPut("bian", -20002);
        spellPut("biao", -19990);
        spellPut("bie", -19986);
        spellPut("bin", -19982);
        spellPut("bing", -19976);
        spellPut("bo", -19805);
        spellPut("bu", -19784);
        spellPut("ca", -19775);
        spellPut("cai", -19774);
        spellPut("can", -19763);
        spellPut("cang", -19756);
        spellPut("cao", -19751);
        spellPut("ce", -19746);
        spellPut("ceng", -19741);
        spellPut("cha", -19739);
        spellPut("chai", -19728);
        spellPut("chan", -19725);
        spellPut("chang", -19715);
        spellPut("chao", -19540);
        spellPut("che", -19531);
        spellPut("chen", -19525);
        spellPut("cheng", -19515);
        spellPut("chi", -19500);
        spellPut("chong", -19484);
        spellPut("chou", -19479);
        spellPut("chu", -19467);
        spellPut("chuai", -19289);
        spellPut("chuan", -19288);
        spellPut("chuang", -19281);
        spellPut("chui", -19275);
        spellPut("chun", -19270);
        spellPut("chuo", -19263);
        spellPut("ci", -19261);
        spellPut("cong", -19249);
        spellPut("cou", -19243);
        spellPut("cu", -19242);
        spellPut("cuan", -19238);
        spellPut("cui", -19235);
        spellPut("cun", -19227);
        spellPut("cuo", -19224);
        spellPut("da", -19218);
        spellPut("dai", -19212);
        spellPut("dan", -19038);
        spellPut("dang", -19023);
        spellPut("dao", -19018);
        spellPut("de", -19006);
        spellPut("deng", -19003);
        spellPut("di", -18996);
        spellPut("dian", -18977);
        spellPut("diao", -18961);
        spellPut("die", -18952);
        spellPut("ding", -18783);
        spellPut("diu", -18774);
        spellPut("dong", -18773);
        spellPut("dou", -18763);
        spellPut("du", -18756);
        spellPut("duan", -18741);
        spellPut("dui", -18735);
        spellPut("dun", -18731);
        spellPut("duo", -18722);
        spellPut("e", -18710);
        spellPut("en", -18697);
        spellPut("er", -18696);
        spellPut("fa", -18526);
        spellPut("fan", -18518);
        spellPut("fang", -18501);
        spellPut("fei", -18490);
        spellPut("fen", -18478);
        spellPut("feng", -18463);
        spellPut("fo", -18448);
        spellPut("fou", -18447);
        spellPut("fu", -18446);
        spellPut("ga", -18239);
        spellPut("gai", -18237);
        spellPut("gan", -18231);
        spellPut("gang", -18220);
        spellPut("gao", -18211);
        spellPut("ge", -18201);
        spellPut("gei", -18184);
        spellPut("gen", -18183);
        spellPut("geng", -18181);
        spellPut("gong", -18012);
        spellPut("gou", -17997);
        spellPut("gu", -17988);
        spellPut("gua", -17970);
        spellPut("guai", -17964);
        spellPut("guan", -17961);
        spellPut("guang", -17950);
        spellPut("gui", -17947);
        spellPut("gun", -17931);
        spellPut("guo", -17928);
        spellPut("ha", -17922);
        spellPut("hai", -17759);
        spellPut("han", -17752);
        spellPut("hang", -17733);
        spellPut("hao", -17730);
        spellPut("he", -17721);
        spellPut("hei", -17703);
        spellPut("hen", -17701);
        spellPut("heng", -17697);
        spellPut("hong", -17692);
        spellPut("hou", -17683);
        spellPut("hu", -17676);
        spellPut("hua", -17496);
        spellPut("huai", -17487);
        spellPut("huan", -17482);
        spellPut("huang", -17468);
        spellPut("hui", -17454);
        spellPut("hun", -17433);
        spellPut("huo", -17427);
        spellPut("ji", -17417);
        spellPut("jia", -17202);
        spellPut("jian", -17185);
        spellPut("jiang", -16983);
        spellPut("jiao", -16970);
        spellPut("jie", -16942);
        spellPut("jin", -16915);
        spellPut("jing", -16733);
        spellPut("jiong", -16708);
        spellPut("jiu", -16706);
        spellPut("ju", -16689);
        spellPut("juan", -16664);
        spellPut("jue", -16657);
        spellPut("jun", -16647);
        spellPut("ka", -16474);
        spellPut("kai", -16470);
        spellPut("kan", -16465);
        spellPut("kang", -16459);
        spellPut("kao", -16452);
        spellPut("ke", -16448);
        spellPut("ken", -16433);
        spellPut("keng", -16429);
        spellPut("kong", -16427);
        spellPut("kou", -16423);
        spellPut("ku", -16419);
        spellPut("kua", -16412);
        spellPut("kuai", -16407);
        spellPut("kuan", -16403);
        spellPut("kuang", -16401);
        spellPut("kui", -16393);
        spellPut("kun", -16220);
        spellPut("kuo", -16216);
        spellPut("la", -16212);
        spellPut("lai", -16205);
        spellPut("lan", -16202);
        spellPut("lang", -16187);
        spellPut("lao", -16180);
        spellPut("le", -16171);
        spellPut("lei", -16169);
        spellPut("leng", -16158);
        spellPut("li", -16155);
        spellPut("lia", -15959);
        spellPut("lian", -15958);
        spellPut("liang", -15944);
        spellPut("liao", -15933);
        spellPut("lie", -15920);
        spellPut("lin", -15915);
        spellPut("ling", -15903);
        spellPut("liu", -15889);
        spellPut("long", -15878);
        spellPut("lou", -15707);
        spellPut("lu", -15701);
        spellPut("lv", -15681);
        spellPut("luan", -15667);
        spellPut("lue", -15661);
        spellPut("lun", -15659);
        spellPut("luo", -15652);
        spellPut("ma", -15640);
        spellPut("mai", -15631);
        spellPut("man", -15625);
        spellPut("mang", -15454);
        spellPut("mao", -15448);
        spellPut("me", -15436);
        spellPut("mei", -15435);
        spellPut("men", -15419);
        spellPut("meng", -15416);
        spellPut("mi", -15408);
        spellPut("mian", -15394);
        spellPut("miao", -15385);
        spellPut("mie", -15377);
        spellPut("min", -15375);
        spellPut("ming", -15369);
        spellPut("miu", -15363);
        spellPut("mo", -15362);
        spellPut("mou", -15183);
        spellPut("mu", -15180);
        spellPut("na", -15165);
        spellPut("nai", -15158);
        spellPut("nan", -15153);
        spellPut("nang", -15150);
        spellPut("nao", -15149);
        spellPut("ne", -15144);
        spellPut("nei", -15143);
        spellPut("nen", -15141);
        spellPut("neng", -15140);
        spellPut("ni", -15139);
        spellPut("nian", -15128);
        spellPut("niang", -15121);
        spellPut("niao", -15119);
        spellPut("nie", -15117);
        spellPut("nin", -15110);
        spellPut("ning", -15109);
        spellPut("niu", -14941);
        spellPut("nong", -14937);
        spellPut("nu", -14933);
        spellPut("nv", -14930);
        spellPut("nuan", -14929);
        spellPut("nue", -14928);
        spellPut("nuo", -14926);
        spellPut("o", -14922);
        spellPut("ou", -14921);
        spellPut("pa", -14914);
        spellPut("pai", -14908);
        spellPut("pan", -14902);
        spellPut("pang", -14894);
        spellPut("pao", -14889);
        spellPut("pei", -14882);
        spellPut("pen", -14873);
        spellPut("peng", -14871);
        spellPut("pi", -14857);
        spellPut("pian", -14678);
        spellPut("piao", -14674);
        spellPut("pie", -14670);
        spellPut("pin", -14668);
        spellPut("ping", -14663);
        spellPut("po", -14654);
        spellPut("pu", -14645);
        spellPut("qi", -14630);
        spellPut("qia", -14594);
        spellPut("qian", -14429);
        spellPut("qiang", -14407);
        spellPut("qiao", -14399);
        spellPut("qie", -14384);
        spellPut("qin", -14379);
        spellPut("qing", -14368);
        spellPut("qiong", -14355);
        spellPut("qiu", -14353);
        spellPut("qu", -14345);
        spellPut("quan", -14170);
        spellPut("que", -14159);
        spellPut("qun", -14151);
        spellPut("ran", -14149);
        spellPut("rang", -14145);
        spellPut("rao", -14140);
        spellPut("re", -14137);
        spellPut("ren", -14135);
        spellPut("reng", -14125);
        spellPut("ri", -14123);
        spellPut("rong", -14122);
        spellPut("rou", -14112);
        spellPut("ru", -14109);
        spellPut("ruan", -14099);
        spellPut("rui", -14097);
        spellPut("run", -14094);
        spellPut("ruo", -14092);
        spellPut("sa", -14090);
        spellPut("sai", -14087);
        spellPut("san", -14083);
        spellPut("sang", -13917);
        spellPut("sao", -13914);
        spellPut("se", -13910);
        spellPut("sen", -13907);
        spellPut("seng", -13906);
        spellPut("sha", -13905);
        spellPut("shai", -13896);
        spellPut("shan", -13894);
        spellPut("shang", -13878);
        spellPut("shao", -13870);
        spellPut("she", -13859);
        spellPut("shen", -13847);
        spellPut("sheng", -13831);
        spellPut("shi", -13658);
        spellPut("shou", -13611);
        spellPut("shu", -13601);
        spellPut("shua", -13406);
        spellPut("shuai", -13404);
        spellPut("shuan", -13400);
        spellPut("shuang", -13398);
        spellPut("shui", -13395);
        spellPut("shun", -13391);
        spellPut("shuo", -13387);
        spellPut("si", -13383);
        spellPut("song", -13367);
        spellPut("sou", -13359);
        spellPut("su", -13356);
        spellPut("suan", -13343);
        spellPut("sui", -13340);
        spellPut("sun", -13329);
        spellPut("suo", -13326);
        spellPut("ta", -13318);
        spellPut("tai", -13147);
        spellPut("tan", -13138);
        spellPut("tang", -13120);
        spellPut("tao", -13107);
        spellPut("te", -13096);
        spellPut("teng", -13095);
        spellPut("ti", -13091);
        spellPut("tian", -13076);
        spellPut("tiao", -13068);
        spellPut("tie", -13063);
        spellPut("ting", -13060);
        spellPut("tong", -12888);
        spellPut("tou", -12875);
        spellPut("tu", -12871);
        spellPut("tuan", -12860);
        spellPut("tui", -12858);
        spellPut("tun", -12852);
        spellPut("tuo", -12849);
        spellPut("wa", -12838);
        spellPut("wai", -12831);
        spellPut("wan", -12829);
        spellPut("wang", -12812);
        spellPut("wei", -12802);
        spellPut("wen", -12607);
        spellPut("weng", -12597);
        spellPut("wo", -12594);
        spellPut("wu", -12585);
        spellPut("xi", -12556);
        spellPut("xia", -12359);
        spellPut("xian", -12346);
        spellPut("xiang", -12320);
        spellPut("xiao", -12300);
        spellPut("xie", -12120);
        spellPut("xin", -12099);
        spellPut("xing", -12089);
        spellPut("xiong", -12074);
        spellPut("xiu", -12067);
        spellPut("xu", -12058);
        spellPut("xuan", -12039);
        spellPut("xue", -11867);
        spellPut("xun", -11861);
        spellPut("ya", -11847);
        spellPut("yan", -11831);
        spellPut("yang", -11798);
        spellPut("yao", -11781);
        spellPut("ye", -11604);
        spellPut("yi", -11589);
        spellPut("yin", -11536);
        spellPut("ying", -11358);
        spellPut("yo", -11340);
        spellPut("yong", -11339);
        spellPut("you", -11324);
        spellPut("yu", -11303);
        spellPut("yuan", -11097);
        spellPut("yue", -11077);
        spellPut("yun", -11067);
        spellPut("za", -11055);
        spellPut("zai", -11052);
        spellPut("zan", -11045);
        spellPut("zang", -11041);
        spellPut("zao", -11038);
        spellPut("ze", -11024);
        spellPut("zei", -11020);
        spellPut("zen", -11019);
        spellPut("zeng", -11018);
        spellPut("zha", -11014);
        spellPut("zhai", -10838);
        spellPut("zhan", -10832);
        spellPut("zhang", -10815);
        spellPut("zhao", -10800);
        spellPut("zhe", -10790);
        spellPut("zhen", -10780);
        spellPut("zheng", -10764);
        spellPut("zhi", -10587);
        spellPut("zhong", -10544);
        spellPut("zhou", -10533);
        spellPut("zhu", -10519);
        spellPut("zhua", -10331);
        spellPut("zhuai", -10329);
        spellPut("zhuan", -10328);
        spellPut("zhuang", -10322);
        spellPut("zhui", -10315);
        spellPut("zhun", -10309);
        spellPut("zhuo", -10307);
        spellPut("zi", -10296);
        spellPut("zong", -10281);
        spellPut("zou", -10274);
        spellPut("zu", -10270);
        spellPut("zuan", -10262);
        spellPut("zui", -10260);
        spellPut("zun", -10256);
        spellPut("zuo", -10254);
        surnamePut("Úó", "y");
        surnamePut("ÄÁ", "m");
        surnamePut("Ñî", "y");
        surnamePut("ìè", "h");
        surnamePut("¹ú", "g");
        surnamePut("Ã×", "m");
        surnamePut("×ó", "z");
        surnamePut("èï", "l");
        surnamePut("Íò", "w");
        surnamePut("ÃÏ", "m");
        surnamePut("Óí", "y");
        surnamePut("Îä", "w");
        surnamePut("×æ", "z");
        surnamePut("Û­", "x");
        surnamePut("â×", "y");
        surnamePut("Çï", "q");
        surnamePut("¹¬", "g");
        surnamePut("Äþ", "n");
        surnamePut("ÍÀ", "t");
        surnamePut("ÖÜ", "z");
        surnamePut("Ôø", "z");
        surnamePut("ºâ", "h");
        surnamePut("Ö£", "z");
        surnamePut("¹Ë", "g");
        surnamePut("¿Õ", "k");
        surnamePut("Óî", "y");
        surnamePut("ãÚ", "q");
        surnamePut("¼§", "j");
        surnamePut("Ëï", "s");
        surnamePut("Áî", "l");
        surnamePut("¹ð", "g");
        surnamePut("Çú", "q");
        surnamePut("ºë", "h");
        surnamePut("ËÕ", "s");
        surnamePut("Âæ", "l");
        surnamePut("ÓÈ", "y");
        surnamePut("ÞÉ", "x");
        surnamePut("Óº", "y");
        surnamePut("Â½", "l");
        surnamePut("ÊÙ", "s");
        surnamePut("Â¡", "l");
        surnamePut("ÑÕ", "y");
        surnamePut("ÐÏ", "x");
        surnamePut("±ð", "b");
        surnamePut("Å·", "o");
        surnamePut("ÐÜ", "x");
        surnamePut("È´", "q");
        surnamePut("¹Ø", "g");
        surnamePut("µÒ", "d");
        surnamePut("·¿", "f");
        surnamePut("ÕÅ", "z");
        surnamePut("Áº", "l");
        surnamePut("ÎÖ", "w");
        surnamePut("Ðí", "x");
        surnamePut("Âí", "m");
        surnamePut("³Â", "c");
        surnamePut("Ñö", "y");
        surnamePut("ºÍ", "h");
        surnamePut("Áú", "l");
        surnamePut("À¶", "l");
        surnamePut("¼Í", "j");
        surnamePut("Û¢", "t");
        surnamePut("»ª", "h");
        surnamePut("ëø", "t");
        surnamePut("³ð", "q");
        surnamePut("Æ½", "p");
        surnamePut("Àä", "l");
        surnamePut("Á¬", "l");
        surnamePut("¶­", "d");
        surnamePut("·ë", "f");
        surnamePut("Îé", "w");
        surnamePut("¾°", "j");
        surnamePut("³²", "c");
        surnamePut("Ñò", "y");
        surnamePut("ÄÂ", "m");
        surnamePut("·ü", "f");
        surnamePut("Å¥", "n");
        surnamePut("Éê", "s");
        surnamePut("ÐÁ", "x");
        surnamePut("Õ¿", "z");
        surnamePut("¸ß", "g");
        surnamePut("Ó÷", "y");
        surnamePut("Æ¤", "p");
        surnamePut("Ë®", "s");
        surnamePut("±Ï", "b");
        surnamePut("ÂÞ", "l");
        surnamePut("¼Æ", "j");
        surnamePut("Óã", "y");
        surnamePut("ÏÄ", "x");
        surnamePut("¶õ", "e");
        surnamePut("Â·", "l");
        surnamePut("Åá", "p");
        surnamePut("ÅÓ", "p");
        surnamePut("¼»", "j");
        surnamePut("°½", "a");
        surnamePut("Àµ", "l");
        surnamePut("Çü", "q");
        surnamePut("Úù", "w");
        surnamePut("°Í", "b");
        surnamePut("Ì¸", "t");
        surnamePut("»¬", "h");
        surnamePut("²Ô", "c");
        surnamePut("»Ê", "h");
        surnamePut("ÖÕ", "z");
        surnamePut("Ã«", "m");
        surnamePut("ôß", "j");
        surnamePut("Êø", "s");
        surnamePut("ÃÓ", "m");
        surnamePut("¼½", "j");
        surnamePut("Ó¦", "y");
        surnamePut("³£", "c");
        surnamePut("¹¢", "g");
        surnamePut("Áø", "l");
        surnamePut("¿ï", "k");
        surnamePut("çÑ", "m");
        surnamePut("À×", "l");
        surnamePut("ºú", "h");
        surnamePut("Óá", "y");
        surnamePut("Ý·", "s");
        surnamePut("°¬", "a");
        surnamePut("Ë«", "s");
        surnamePut("Îµ", "w");
        surnamePut("Íô", "w");
        surnamePut("½ð", "j");
        surnamePut("Ç¿", "q");
        surnamePut("Ê·", "s");
        surnamePut("Ðû", "x");
        surnamePut("ÌÀ", "t");
        surnamePut("×¯", "z");
        surnamePut("ÀÖ", "l");
        surnamePut("»Ý", "h");
        surnamePut("´¾", "c");
        surnamePut("ØÇ", "s");
        surnamePut("Ñà", "y");
        surnamePut("¸»", "f");
        surnamePut("Ò¦", "y");
        surnamePut("Áõ", "l");
        surnamePut("Âú", "m");
        surnamePut("Õ²", "z");
        surnamePut("ÈÄ", "r");
        surnamePut("ÆÑ", "p");
        surnamePut("Ë¾", "s");
        surnamePut("×£", "z");
        surnamePut("Í¨", "t");
        surnamePut("Î¤", "w");
        surnamePut("è³", "q");
        surnamePut("ñÒ", "c");
        surnamePut("³Ø", "c");
        surnamePut("Ò¶", "y");
        surnamePut("ÉÐ", "s");
        surnamePut("´÷", "d");
        surnamePut("Ì«", "t");
        surnamePut("¹ù", "g");
        surnamePut("¸Ê", "g");
        surnamePut("ºÕ", "h");
        surnamePut("ñã", "x");
        surnamePut("Û¬", "g");
        surnamePut("³µ", "c");
        surnamePut("Ó¡", "y");
        surnamePut("µÔ", "d");
        surnamePut("Óô", "y");
        surnamePut("ñ¼", "d");
        surnamePut("Òæ", "y");
        surnamePut("Îº", "w");
        surnamePut("ÓÝ", "y");
        surnamePut("ÇØ", "q");
        surnamePut("ÈÎ", "r");
        surnamePut("·Ñ", "f");
        surnamePut("ÃÉ", "m");
        surnamePut("´þ", "d");
        surnamePut("²·", "b");
        surnamePut("¹ã", "g");
        surnamePut("ÄÇ", "n");
        surnamePut("Úû", "b");
        surnamePut("¹­", "g");
        surnamePut("ºó", "h");
        surnamePut("Ð»", "x");
        surnamePut("ÆÝ", "q");
        surnamePut("Ö§", "z");
        surnamePut("ÓÎ", "y");
        surnamePut("½ª", "j");
        surnamePut("ºì", "h");
        surnamePut("ÉØ", "s");
        surnamePut("ÆÖ", "p");
        surnamePut("º¼", "h");
        surnamePut("Í¯", "t");
        surnamePut("´Ó", "c");
        surnamePut("¹Å", "g");
        surnamePut("É£", "s");
        surnamePut("×Ú", "z");
        surnamePut("Ê¯", "s");
        surnamePut("µó", "d");
        surnamePut("·û", "f");
        surnamePut("Â¬", "l");
        surnamePut("¶¡", "d");
        surnamePut("Éò", "s");
        surnamePut("ÖÓ", "z");
        surnamePut("ËÎ", "s");
        surnamePut("ºî", "h");
        surnamePut("É³", "s");
        surnamePut("¿×", "k");
        surnamePut("µ³", "d");
        surnamePut("°ü", "b");
        surnamePut("¼®", "j");
        surnamePut("°²", "a");
        surnamePut("°à", "b");
        surnamePut("Ðë", "x");
        surnamePut("Öî", "z");
        surnamePut("ÕÔ", "z");
        surnamePut("ôÃ", "q");
        surnamePut("¿µ", "k");
        surnamePut("½¹", "j");
        surnamePut("Èã", "r");
        surnamePut("Àè", "l");
        surnamePut("·á", "f");
        surnamePut("Íõ", "w");
        surnamePut("ôà", "y");
        surnamePut("²½", "b");
        surnamePut("·¶", "f");
        surnamePut("³¤", "z");
        surnamePut("Ôª", "y");
        surnamePut("ÀÍ", "l");
        surnamePut("Â³", "l");
        surnamePut("²é", "c");
        surnamePut("Ýþ", "l");
        surnamePut("Ã©", "m");
        surnamePut("ºé", "h");
        surnamePut("¼Ö", "j");
        surnamePut("½â", "j");
        surnamePut("¹´", "g");
        surnamePut("Ìï", "t");
        surnamePut("²Ü", "c");
        surnamePut("åµ", "m");
        surnamePut("½¯", "j");
        surnamePut("Èî", "r");
        surnamePut("»¸", "h");
        surnamePut("±«", "b");
        surnamePut("Î£", "w");
        surnamePut("ÁÖ", "l");
        surnamePut("Äß", "n");
        surnamePut("µË", "d");
        surnamePut("ÌÕ", "t");
        surnamePut("ºØ", "h");
        surnamePut("Î×", "w");
        surnamePut("±©", "b");
        surnamePut("±ß", "b");
        surnamePut("³Ì", "c");
        surnamePut("»³", "h");
        surnamePut("±å", "b");
        surnamePut("ê°", "z");
        surnamePut("ÔÆ", "y");
        surnamePut("¸µ", "f");
        surnamePut("Ô×", "z");
        surnamePut("¶«", "d");
        surnamePut("ö¤", "z");
        surnamePut("êÚ", "b");
        surnamePut("ãÛ", "y");
        surnamePut("Àú", "l");
        surnamePut("Åí", "p");
        surnamePut("Ûº", "f");
        surnamePut("ÈÙ", "r");
        surnamePut("ÐÒ", "x");
        surnamePut("Îâ", "w");
        surnamePut("°×", "b");
        surnamePut("Êæ", "s");
        surnamePut("¿Â", "k");
        surnamePut("ÈÝ", "r");
        surnamePut("Æî", "q");
        surnamePut("ÎÚ", "w");
        surnamePut("ÌÆ", "t");
        surnamePut("Õç", "z");
        surnamePut("»Æ", "h");
        surnamePut("Àî", "l");
        surnamePut("ÎÂ", "w");
        surnamePut("ÅË", "p");
        surnamePut("Ñ¦", "x");
        surnamePut("äß", "p");
        surnamePut("åÌ", "p");
        surnamePut("ïú", "j");
        surnamePut("ÎÌ", "w");
        surnamePut("Ûª", "l");
        surnamePut("¼³", "j");
        surnamePut("É÷", "s");
        surnamePut("Àû", "l");
        surnamePut("Ïî", "x");
        surnamePut("È¨", "q");
        surnamePut("ÕÂ", "z");
        surnamePut("ËÞ", "s");
        surnamePut("¾Ï", "j");
        surnamePut("¹®", "g");
        surnamePut("Äª", "m");
        surnamePut("Ï¯", "x");
        surnamePut("Öì", "z");
        surnamePut("ÒÁ", "y");
        surnamePut("êË", "c");
        surnamePut("öÄ", "q");
        surnamePut("³ä", "c");
        surnamePut("ÑÏ", "y");
        surnamePut("Ï°", "x");
        surnamePut("¸É", "g");
        surnamePut("Ä½", "m");
        surnamePut("¾®", "j");
        surnamePut("É½", "s");
        surnamePut("ÏÌ", "x");
        surnamePut("ÜÇ", "r");
        surnamePut("Â¦", "l");
        surnamePut("ÑÖ", "y");
        surnamePut("¼Ò", "j");
        surnamePut("¶¼", "d");
        surnamePut("Ç®", "q");
        surnamePut("Òü", "y");
        surnamePut("Åî", "p");
        surnamePut("¸ê", "g");
        surnamePut("»ô", "h");
        surnamePut("Ø¿", "n");
        surnamePut("¶Â", "d");
        surnamePut("ÂÀ", "l");
        surnamePut("ÉÛ", "s");
        surnamePut("Á®", "l");
        surnamePut("Ê¢", "s");
        surnamePut("²Ì", "c");
        surnamePut("ÎÄ", "w");
        surnamePut("±´", "b");
        surnamePut("×Þ", "z");
        surnamePut("ì¯", "s");
        surnamePut("½ù", "j");
        surnamePut("Ê¦", "s");
        surnamePut("Â»", "l");
        surnamePut("î×", "d");
        surnamePut("å§", "p");
        surnamePut("Ïà", "x");
        surnamePut("²ý", "c");
        surnamePut("¾Ó", "j");
        surnamePut("¼¾", "j");
        surnamePut("²ñ", "c");
        surnamePut("Äô", "n");
        surnamePut("Ñø", "y");
        surnamePut("´¢", "c");
        surnamePut("êÃ", "z");
        surnamePut("¹¨", "g");
        surnamePut("¿Ü", "k");
        surnamePut("»¨", "h");
        surnamePut("µ¥", "s");
        surnamePut("·â", "f");
        surnamePut("È«", "q");
        surnamePut("·®", "f");
        surnamePut("Áè", "l");
        surnamePut("Óà", "y");
        surnamePut("¶Î", "d");
        surnamePut("Ñô", "y");
        surnamePut("Òó", "y");
        surnamePut("×¿", "z");
        surnamePut("½­", "j");
        surnamePut("Îã", "w");
        surnamePut("Âé", "m");
        surnamePut("ÀÉ", "l");
        surnamePut("Å©", "n");
        surnamePut("º«", "h");
        surnamePut("Ê±", "s");
        surnamePut("¶Å", "d");
        surnamePut("Ðì", "x");
        surnamePut("ÓÚ", "y");
        surnamePut("Ê©", "s");
        surnamePut("°Ø", "b");
        surnamePut("¹È", "g");
        surnamePut("Ã·", "m");
        surnamePut("Ùç", "k");
        surnamePut("¾£", "j");
        surnamePut("Ô½", "y");
        surnamePut("Î¾", "w");
        surnamePut("ÈÖ", "r");
        surnamePut("¹±", "g");
        surnamePut("Å£", "n");
        surnamePut("Ðù", "x");
        surnamePut("ÎÀ", "w");
        surnamePut("ÁÎ", "l");
        surnamePut("Æë", "q");
        surnamePut("Ã÷", "m");
        surnamePut("·ö", "f");
        surnamePut("Ì·", "t");
        surnamePut("¹«", "g");
        surnamePut("Ë÷", "s");
        surnamePut("êÌ", "y");
        surnamePut("óÃ", "z");
        surnamePut("¼ò", "j");
        surnamePut("ÎÅ", "w");
        surnamePut("Ïò", "x");
        surnamePut("Øá", "k");
        surnamePut("îÁ", "h");
        surnamePut("ËÉ", "s");
        surnamePut("ÖÙ", "z");
        surnamePut("ÉÏ", "s");
        surnamePut("¸ð", "g");
        surnamePut("³É", "c");
        surnamePut("ÄÜ", "n");
        surnamePut("å£", "t");
        surnamePut("ÇÇ", "q");
        surnamePut("´Þ", "c");
        surnamePut("ÈÚ", "r");
        surnamePut("Ü÷", "x");
        surnamePut("á¯", "c");
        surnamePut("·½", "f");
        surnamePut("»Â", "h");
        surnamePut("ºÂ", "h");
        surnamePut("¼ª", "j");
        surnamePut("Ò×", "y");
        surnamePut("ãÉ", "m");
        surnamePut("·ï", "f");
        surnamePut("Ïô", "x");
        surnamePut("ºÎ", "h");
        surnamePut("Ô¬", "y");
        surnamePut("Ãç", "m");
        surnamePut("¹Ü", "g");
        surnamePut("Çñ", "q");
        surnamePut("È½", "r");
        surnamePut("¹¶", "g");
        surnamePut("À´", "l");
        surnamePut("ÖÖ", "z");
        surnamePut("°¢", "a");
        surnamePut("À¼", "l");
        surnamePut("¶û", "e");
        surnamePut("ÄÉ", "n");
        surnamePut("Åô", "p");
        surnamePut("Â¥", "l");
        surnamePut("Ä²", "m");
        surnamePut("þŸ", "y");
    }

    /**
     * »ñµÃµ¥¸öºº×ÖµÄAscii.
     *
     * @param cn char ºº×Ö×Ö·û
     * @return int ´íÎó·µ»Ø 0,·ñÔò·µ»Øascii
     */
    public static int getCnAscii(char cn) {
        byte[] bytes = null;
        try {
            bytes = (String.valueOf(cn)).getBytes("GBK");
        } catch (UnsupportedEncodingException e) {
            return 0;
        }
        if (bytes == null || bytes.length > 2 || bytes.length <= 0) { // ´íÎó
            return 0;
        }
        if (bytes.length == 1) { // Ó¢ÎÄ×Ö·û
            return bytes[0];
        }
        if (bytes.length == 2) { // ÖÐÎÄ×Ö·û
            int hightByte = 256 + bytes[0];
            int lowByte = 256 + bytes[1];
            int ascii = (256 * hightByte + lowByte) - 256 * 256;
            return ascii;
        }
        return 0; // ´íÎó
    }

    /**
     * ¸ù¾ÝASCIIÂëµ½SpellMapÖÐ²éÕÒ¶ÔÓ¦µÄÆ´Òô
     *
     * @param ascii int ×Ö·û¶ÔÓ¦µÄASCII
     * @return String Æ´Òô,Ê×ÏÈÅÐ¶ÏASCIIÊÇ·ñ>0& <160,Èç¹ûÊÇ·µ»Ø¶ÔÓ¦µÄ×Ö·û,
     * <p>
     * ·ñÔòµ½SpellMapÖÐ²éÕÒ,Èç¹ûÃ»ÓÐÕÒµ½Æ´Òô,Ôò·µ»Ønull,Èç¹ûÕÒµ½Ôò·µ»ØÆ´Òô.
     */
    public static String getSpellByAscii(int ascii) {
        if (ascii > 0 && ascii < 160) { // µ¥×Ö·û
            return String.valueOf((char) ascii);
        }
        if (ascii < -20319 || ascii > -10247) { // ²»ÖªµÀµÄ×Ö·û
            return null;
        }
        Set<String> keySet = spellMap.keySet();
        Iterator<String> it = keySet.iterator();
        String spell0 = null;
        String spell = null;
        int asciiRang0 = -20319;
        int asciiRang;
        while (it.hasNext()) {
            spell = it.next();
            Object valObj = spellMap.get(spell);
            if (valObj instanceof Integer) {
                asciiRang = ((Integer) valObj).intValue();
                if (ascii >= asciiRang0 && ascii < asciiRang) { // Çø¼äÕÒµ½
                    return (spell0 == null) ? spell : spell0;
                } else {
                    spell0 = spell;
                    asciiRang0 = asciiRang;
                }
            }
        }
        return null;
    }

    /**
     * ·µ»Ø×Ö·û´®µÄÈ«Æ´,ÊÇºº×Ö×ª»¯ÎªÈ«Æ´,ÆäËü×Ö·û²»½øÐÐ×ª»»
     *
     * @param cnStr String ×Ö·û´®
     * @return String ×ª»»³ÉÈ«Æ´ºóµÄ×Ö·û´®
     */
    public static String getFullSpell(String cnStr) {
        if (Validators.isEmpty(cnStr)) {
            return cnStr;
        }
        char[] chars = cnStr.toCharArray();
        StringBuilder retuBuf = new StringBuilder();
        for (int i = 0, Len = chars.length; i < Len; i++) {
            int ascii = getCnAscii(chars[i]);
            if (ascii == 0) { // È¡asciiÊ±³ö´í
                retuBuf.append(chars[i]);
            } else {
                String spell = getSpellByAscii(ascii);
                if (spell == null) {
                    retuBuf.append(chars[i]);
                } else {
                    retuBuf.append(spell);
                } // end of if spell == null
            } // end of if ascii <= -20400
        } // end of for
        return retuBuf.toString();
    }

    /**
     * È¡µÃ×Ö·ûµÄÖÐÎÄÆ´Òô
     *
     * @param cnChar
     * @return ×Ö·ûµÄÖÐÎÄÆ´Òô
     */
    public static String getFullSpell(char cnChar) {
        return getFullSpell(new String(new char[]{cnChar}));
    }

    /**
     * È¡µÃ×Ö·ûµÄÖÐÎÄÆ´ÒôÊ××ÖÄ¸
     *
     * @param cnChar
     * @return ×Ö·ûµÄÖÐÎÄÆ´ÒôÊ××ÖÄ¸
     */
    public static String getFirstSpell(char cnChar) {
        String str = getFullSpell(cnChar);
        if (Validators.isEmpty(str)) {
            return str;
        }
        return new String(new char[]{str.charAt(0)});
    }

    /**
     * È¡µÃÖÐÎÄÆ´ÒôÊ××ÖÄ¸
     *
     * @param cnStr
     * @return ÖÐÎÄÆ´ÒôÊ××ÖÄ¸
     */
    public static String getFirstSpell(String cnStr) {
        if (Validators.isEmpty(cnStr)) {
            return cnStr;
        }
        StringBuilder StringBuilder = new StringBuilder();
        for (int i = 0; i < cnStr.length(); i++) {
            StringBuilder.append(getFirstSpell(cnStr.charAt(i)));
        }
        return StringBuilder.toString();
    }

    /**
     * È¡µÃÖÐÎÄµÄÆ´ÒôËõÐ´£¬ÆäÖÐµÚÒ»¸öÎªÈ«Æ´£¬ºóÃæÎªÊ××ÖÄ¸
     *
     * @param cnStr
     * @return Æ´ÒôËõÐ´
     */
    public static String getAbbreviateSpell(String cnStr) {
        if (Validators.isEmpty(cnStr)) {
            return cnStr;
        }
        StringBuilder StringBuilder = new StringBuilder();
        for (int i = 0; i < cnStr.length(); i++) {
            if (i == 0) {
                StringBuilder.append(getFullSpell(cnStr.charAt(i)));
            } else {
                StringBuilder.append(getFirstSpell(cnStr.charAt(i)));
            }
        }
        return StringBuilder.toString();
    }

    /**
     * È¡µÃÐÕµÄÆ´ÒôÊ××ÖÄ¸
     *
     * @param cnName ÐÕÃû
     * @return ÐÕµÄÆ´ÒôÊ××ÖÄ¸
     */
    public static String getSurnameFirstSpell(String cnName) {
        if (Validators.isEmpty(cnName)) {
            return cnName;
        }
        String surnameFirstSpell = surnameMap.get(cnName.substring(0, 1));
        return surnameFirstSpell;
    }

    /**
     * È¡µÃÒ»ÅúÐÕÃûµÄÐÕµÄÊ××ÖÄ¸×Ö·û´®Êý×é
     *
     * @param cnNames ÐÕÃû×Ö·û´®Êý×é
     * @return Ê××ÖÄ¸×Ö·û´®Êý×é
     */
    public static String[] getSurnameFirstSpellRange(String[] cnNames) {
        HashSet<String> surnameFirstSpellSet = new HashSet<String>();
        for (int i = 0; i < cnNames.length; i++) {
            String surnameFirstSpell = getSurnameFirstSpell(cnNames[i]);
            if (surnameFirstSpell != null) {
                surnameFirstSpellSet.add(surnameFirstSpell);
            }
        }
        ArrayList<String> surnameFirstSpellList = new ArrayList<String>(surnameFirstSpellSet);
        Collections.sort(surnameFirstSpellList);
        return ArrayUtils.toArray(surnameFirstSpellList);
    }
}
