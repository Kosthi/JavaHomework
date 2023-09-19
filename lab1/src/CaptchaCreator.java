import java.awt.image.BufferedImage;
import java.io.File;
import java.security.SecureRandom;
import java.util.*;
import java.util.stream.Collectors;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.apache.commons.lang3.RandomStringUtils;

import javax.imageio.ImageIO;

public class CaptchaCreator {
    // 随机含字母数字的4位验证码
    public String getText() {
        return RandomStringUtils.randomAlphanumeric(4);
    }

    // 随机含字母数字的4-6位验证码
    public String getExtendedText() {
        Random random = new Random();
        return RandomStringUtils.randomAlphanumeric(random.nextInt(3) + 4);
    }

    // 随机含特定数量的字母和数字的4-6位验证码
    public String getExtendedText(int numLetters, int numDigits) {
        if (numLetters + numDigits < 4 || numLetters + numDigits > 6) {
            throw new IllegalArgumentException("The total length of letters and digits combined must be between 4 and 6.");
        }

        String letters = RandomStringUtils.randomAlphabetic(numLetters);
        String digits = RandomStringUtils.randomNumeric(numDigits);

        String combined = letters + digits;

        // 将字符串转换为字符列表并混洗
        List<Character> chars = combined.chars()
                                        .mapToObj(c -> (char)c)
                                        .collect(Collectors.toList());
        Collections.shuffle(chars);

        // 将字符列表转回字符数组
        char[] charArray = chars.stream()
                                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                                .toString()
                                .toCharArray();

        return new String(charArray);
    }

    // 生成验证码文本对应的图片
    public void getPhoto(String captchaText) {
        DefaultKaptcha kaptchaProducer = new DefaultKaptcha();
        Properties properties = new Properties();
        properties.put("kaptcha.textproducer.char.length", captchaText.length());
        properties.put("kaptcha.border", "yes");
        properties.put("kaptcha.border.color", "220,220,220");
        properties.put("kaptcha.textproducer.font.color", "38,29,12");
        // properties.put("kaptcha.image.width", "125");

        // 根据文本自适应图片宽度
        properties.put("kaptcha.image.width", String.valueOf(150 * captchaText.length() / 4));

        properties.put("kaptcha.image.height", "45");
        properties.put("kaptcha.session.key", "code");
        Config config = new Config(properties);
        kaptchaProducer.setConfig(config);

        // Generate the captcha text
        // String captchaText = kaptchaProducer.createText();
        // System.out.println("Generated Captcha Text = " + captchaText);

        // Create the captcha image
        BufferedImage image = kaptchaProducer.createImage(captchaText);

        // Save the image to a file
        try {
            ImageIO.write(image, "jpg", new File(captchaText + "captcha.jpg"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    // 同时生成验证码文本和其对应的图片
    public void getTextAndPhoto() {
        DefaultKaptcha kaptchaProducer = new DefaultKaptcha();
        Properties properties = new Properties();
        properties.put("kaptcha.border", "yes");
        properties.put("kaptcha.border.color", "220,220,220");
        properties.put("kaptcha.textproducer.font.color", "38,29,12");
        properties.put("kaptcha.image.width", "125");
        properties.put("kaptcha.image.height", "45");
        properties.put("kaptcha.session.key", "code");

        // Generate the captcha text
        // String captchaText = kaptchaProducer.createText();
        String captchaText = getExtendedText();
        properties.put("kaptcha.textproducer.char.length", captchaText.length());
        Config config = new Config(properties);
        kaptchaProducer.setConfig(config);

        System.out.println("Generated Captcha Text = " + captchaText);

        // Create the captcha image
        BufferedImage image = kaptchaProducer.createImage(captchaText);

        // Save the image to a file
        try {
            ImageIO.write(image, "jpg", new File(captchaText + "captcha.jpg"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private static final String[] CNUMBERS = "0,1,2,3,4,5,6,7,8,9,10".split(",");

    // 智力题验证码 加减乘除
    public String getCalText() {
        SecureRandom random = new SecureRandom();
        int x = random.nextInt(10);
        int y = random.nextInt(10);
        StringBuilder suChinese = new StringBuilder();
        int randomOperands = (int) Math.round(Math.random() * 2);
        if (randomOperands == 0) {
            // result = x * y;
            suChinese.append(CNUMBERS[x]);
            suChinese.append("*");
            suChinese.append(CNUMBERS[y]);
        } else if (randomOperands == 1) {
            if (!(x == 0) && y % x == 0) {
                // result = y / x;
                suChinese.append(CNUMBERS[y]);
                suChinese.append("/");
                suChinese.append(CNUMBERS[x]);
            } else {
                // result = x + y;
                suChinese.append(CNUMBERS[x]);
                suChinese.append("+");
                suChinese.append(CNUMBERS[y]);
            }
        } else if (randomOperands == 2) {
            // result = x - y;
            suChinese.append(CNUMBERS[y]);
            suChinese.append("-");
            suChinese.append(CNUMBERS[x]);
        } else {
            // result = x + y;
            suChinese.append(CNUMBERS[x]);
            suChinese.append("+");
            suChinese.append(CNUMBERS[y]);
        }
        // suChinese.append("=?@").append(result);
        return suChinese.toString();
    }

    // 问答题验证码 HashMap存储问题和答案
    public String getChoiceText() {
        ChoiceCaptcha choiceCaptcha = new ChoiceCaptcha();
        return choiceCaptcha.getRandomQuestion();
    }

    // 中文验证码
    public String getChineseText() {
        DefaultKaptcha kaptchaProducer = new DefaultKaptcha();
        Properties properties = new Properties();
        // 使用中文字符集
        properties.put("kaptcha.textproducer.char.string", "噫吁嚱，危乎高哉！蜀道之难，难于上青天！蚕丛及鱼凫，开国何茫然！尔来四万八千岁，不与秦塞通人烟。西当太白有鸟道，可以横绝峨眉巅。地崩山摧壮士死，然后天梯石栈相钩连。上有六龙回日之高标，下有冲波逆折之回川。黄鹤之飞尚不得过，猿猱欲度愁攀援。青泥何盘盘，百步九折萦岩峦。扪参历井仰胁息，以手抚膺坐长叹。\n" +
                "\n" +
                "问君西游何时还？畏途巉岩不可攀。但见悲鸟号古木，雄飞雌从绕林间。又闻子规啼夜月，愁空山。蜀道之难，难于上青天，使人听此凋朱颜！连峰去天不盈尺，枯松倒挂倚绝壁。飞湍瀑流争喧豗，砯崖转石万壑雷。其险也如此，嗟尔远道之人胡为乎来哉！\n" +
                "\n" +
                "剑阁峥嵘而崔嵬，一夫当关，万夫莫开。所守或匪亲，化为狼与豺。朝避猛虎，夕避长蛇；磨牙吮血，杀人如麻。锦城虽云乐，不如早还家。蜀道之难，难于上青天，侧身西望长咨嗟！");
        properties.put("kaptcha.textproducer.char.length", "4");

        // 其他配置，例如字体、颜色等
        properties.put("kaptcha.background.clear.from", "white");
        properties.put("kaptcha.background.clear.to", "white");
        properties.put("kaptcha.image.width", "120");
        properties.put("kaptcha.image.height", "40");

        Config config = new Config(properties);
        kaptchaProducer.setConfig(config);
        return kaptchaProducer.createText();
    }

    public void Test() {
        CaptchaCreator cc = new CaptchaCreator();
        // 基本测试
        System.out.println("测试生成4位验证码");
        System.out.println(cc.getText());
        System.out.println("测试生成4-6位验证码");
        System.out.println(cc.getExtendedText());

        System.out.println("测试生成2位字母和3位数字验证码");
        System.out.println(cc.getExtendedText(2, 3));
        System.out.println("测试生成验证码图片");
        cc.getPhoto(cc.getExtendedText());
        System.out.println("测试生成验证码和验证码图片");
        cc.getTextAndPhoto();

        // 测试智力验证码
        System.out.println("测试智力题验证码");
        String calText = cc.getCalText();
        System.out.println("智力题验证码：" + calText);
        System.out.println("测试生成智力题验证码图片");
        cc.getPhoto(calText);

        // 测试问答题验证码
        System.out.println("测试智力题验证码");
        String choiceText = cc.getChoiceText();
        System.out.println("问答题验证码：" + choiceText);
        System.out.println("测试问答题验证码图片");
        cc.getPhoto(choiceText);

        // 测试中文验证码
        System.out.println("测试中文验证码");
        String chineseText = cc.getChineseText();
        System.out.println("中文验证码：" + chineseText);
        System.out.println("测试中文验证码图片");
        cc.getPhoto(chineseText);
    }
}

class ChoiceCaptcha {
    private final Map<String, String> questionBank = new HashMap<>();

    public ChoiceCaptcha() {
        questionBank.put("太阳在哪个星系?", "银河系");
        questionBank.put("哪个行星被称为红色星球?", "火星");
        // ... 添加更多题目
    }

    public String getRandomQuestion() {
        // 转化成数组类型
        Object[] questions = questionBank.keySet().toArray();
        // 随机生成下标的数组
        return (String) questions[new Random().nextInt(questions.length)];
    }

    public boolean checkAnswer(String question, String answer) {
        return questionBank.get(question).equals(answer);
    }
}
