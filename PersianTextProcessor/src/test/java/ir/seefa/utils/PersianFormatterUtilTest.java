package ir.seefa.utils;

import org.junit.Assert;
import org.junit.Test;
import org.apache.commons.lang.StringEscapeUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Saman Delfani
 * @version 1.0
 * @since 26 Jan 2017
 */
public class PersianFormatterUtilTest {
    @Test
    public void testConvertNumberChars() {
        String testText1 = "\\u062F\\u0631 \\u0633\\u0627\\u0644 \\u06F1\\u06F3\\u06F9\\u06F5 \\u0628\\u0631\\u0627\\u06CC \\u062A\\u0633\\u062A \\u062A\\u0628\\u062F\\u06CC\\u0644 \\u0627\\u0639\\u062F\\u0627\\u062F \\u0628\\u0647 \\u06A9\\u0627\\u0631\\u0627\\u06A9\\u062A\\u0631 \\u06F1\\u06F2\\u06F3\\u06F4\\u06F5\\u06F6\\u06F7\\u06F8\\u06F9\\u06F0 \\u0641\\u0627\\u0631\\u0633\\u06CC \\u0627\\u0633\\u062A\\u0641\\u0627\\u062F\\u0647 \\u0634\\u062F\\u0647 \\u0627\\u0633\\u062A";
        String testText2 = "\\u062F\\u0631 \\u0633\\u0627\\u0644 \\u0661\\u0663\\u0669\\u0665 \\u0628\\u0631\\u0627\\u06CC \\u062A\\u0633\\u062A \\u062A\\u0628\\u062F\\u06CC\\u0644 \\u0627\\u0639\\u062F\\u0627\\u062F \\u0628\\u0647 \\u06A9\\u0627\\u0631\\u0627\\u06A9\\u062A\\u0631 \\u0661\\u0662\\u0663\\u0664\\u06F5\\u0666\\u0667\\u0668\\u0669\\u0660 \\u0641\\u0627\\u0631\\u0633\\u06CC \\u0627\\u0633\\u062A\\u0641\\u0627\\u062F\\u0647 \\u0634\\u062F\\u0647 \\u0627\\u0633\\u062A";
        String resultText = "در سال 1395 برای تست تبدیل اعداد به کاراکتر 1234567890 فارسی استفاده شده است";
        String resultFunction1 = PersianFormatterUtil.convertNumberChars(StringEscapeUtils.unescapeJava(testText1));
        String resultFunction2 = PersianFormatterUtil.convertNumberChars(StringEscapeUtils.unescapeJava(testText2));
        Assert.assertTrue(resultText.equals(resultFunction1));
        Assert.assertTrue(resultText.equals(resultFunction2));
    }

    @Test
    public void testConvertSpecialChars() {
        String testText = "\\u0633\\u06CC\\u0641\\u0627 \\u062F\\u0627\\u0631\\u0627\\u0626 \\u0637\\u0631\\u0627\\u062D\\u0649 \\u0627\\u062C\\u0631\\u0627\\u06CC\\u06CC \\u0624\\u0628 \\u0643\\u0647 \\u0628\\u0627 \\u06AC\\u0631\\u0648\\u0629 \\u0628\\u0646\\u062F\\u06CC \\u06A9\\u062F\\u0647\\u0627 \\u0627\\u0645\\u06A9\\u0627\\u0646\\u0627\\u062A \\u062A\\u0648\\u0633\\u0639\\u0647 \\u0645\\u062D\\u0635\\u0648\\u0644 \\u0647\\u0627\\u06CC \\u0647\\u0627\\u06CC \\u062A\\u06A9 \\u0631\\u0627 \\u062F\\u0627\\u0631\\u062F";
        String resultText = "سيفا داراي طراحي اجرايي وب که با گروه بندي کدها امکانات توسعه محصول هاي هاي تک را دارد";
        String resultFunction = PersianFormatterUtil.convertSpecialChars(StringEscapeUtils.unescapeJava(testText));
        Assert.assertTrue(resultText.equals(resultFunction));
    }

    @Test
    public void testconvertMirrorChars() {
        String testText = "این متن برای تست(پرانتز) و {برکت های آکلادی} و [برکت های مربعی] می باشد. همچنین (پرانتزهای ((تودرتو)) و {(سایر) برکت های }{تکی} و چندتایی} تست می گردد. همچنین ترکیب English{for text} and [Bracket][] and {other} brackets will be test. در پایان متشکریم. ";
        String resultText = "این متن برای تست)پرانتز( و }برکت های آکلادی{ و ]برکت های مربعی[ می باشد. همچنین )پرانتزهای ))تودرتو(( و })سایر( برکت های {}تکی{ و چندتایی{ تست می گردد. همچنین ترکیب English}for text{ and ]Bracket[][ and }other{ brackets will be test. در پایان متشکریم. ";
        String resultFunction = PersianFormatterUtil.convertMirrorChars(testText);
        Assert.assertTrue(resultFunction.equals(resultText));
    }

    @Test
    public void testReverseNumberAndNonPersianCharacters() {

        List<String> testStrings = new ArrayList<String>();
        // sample text from http://www.hamyarit.com and http://uut.ac.ir and http://seefa.ir and http://118.tct.ir
        testStrings.add("سلام بر تست Hi This is my test for English و 123-444-987");
        testStrings.add("امروزه افراد زیادی از واژه پرداز محبوب شرکت مایکروسافت یعنی “واژه پرداز مایکروسافت ورد” استفاده میکنند، این نرم\u200Cافزار در میان کاربران فارسی زبان نیز از اهمیت ویژه\u200Cای برخوردار است و خیلی از کاربران ویندوز اعم از کاربران حرفه\u200Cای و آماتور از این برنامه برای ایجاد و ویرایش اسناد متنی خود استفاده میکند، این ابزار با امکانات و ویژگی\u200Cهای منحصر به فرد خود کاربران زیادی را جذب کرده است و امکان ویرایش متون به اکثر زبان\u200Cهای رایج دنیا در آن وجود دارد که زبان فارسی نیز یکی از آن\u200Cهاست، در ادامه با همیار آی\u200Cتی همراه باشید تا با هم نحوه نگارش صحیح جملات فارسی را در نرم\u200Cافزار مایکروسافت ورد مرور کنیم.");
        testStrings.add("توجه: این کار تمام جملات شما را به صورت راست\u200Cچین نمایش میدهد، برای ارائه یک متن مرتب بهتر است Alignment را در حالت Justify قرار دهید.");
        testStrings.add("یکی از راه\u200Cهای تنظیم فونت استفاده از منوی Font در تب Home میباشد ولی اگر بخواهید فونت خاصی را به کل نوشته اختصاص دهید (به صورت مجزا برای کلمات فارسی و انگلیسی) باید طبق روش زیر عمل کنید.\n" +
                "مطابق تصویر زیر بر روی علامت کوچکی که در گوشه\u200Cی منوی Font قرار دارد کلیک کنید.");
        testStrings.add("شما میتوانید با هر نوع فونتی که تمایل داشته باشید متن خود را بنویسید ولی اگر از یک فونت مناسب که برای زبان فارسی بهینه شده استفاده کنید زیبایی و خوانایی متن شما دو چندان خواهد شد، پس همواره این نکته را به یاد داشته باشید، معمولا فونت\u200Cهایی که با حروفی مانند B- یا IR- و Fa- آغاز میشوند مناسب نگارش فارسی هستند (البته استثنائاتی نیز در اینجا وجود دارد)");
        testStrings.add("سعی کنید همیشه و در محل مناسب از علائم نگارشی استفاده کنید تا متن شما راحت\u200Cتر قابل خواندن باشد، اجزای اصلی علائم نگارشی در زبان پارسی شامل [\u200C؟\u200C!\u200C. ،: ؛ ” ” () … ] میشوند، البته نحوه استفاده از آن\u200Cها نیز اصول خاصی دارد که در ادامه به آن\u200Cها می\u200Cپردازیم.");
        testStrings.add("پس از اینکه جمله\u200Cی مورد نظر خود را نوشتید در انتهای جمله و بدون درج هیچ\u200Cگونه فاصله\u200Cای علامت مناسب را قرار داده و سپس یک فاصله (Space) درج کنید.\n" +
                "الگوی صحیح استفاده از این علائم به این صورت است:\n" +
                "… [عبارت] [علائم نگارشی] [فاصله] [عبارت] …");
        testStrings.add("شیوه نادرست:\n" +
                "عبارت قبل( عبارت میان پرانتز  )عبارت بعد\n" +
                "[  عبارت داخل کروشه  ]عبارت بعد\n" +
                "عبارت”  داخل گیومه  “");

        testStrings.add("شیوه صحیح:\n" +
                "عبارت قبل (عبارت میان پرانتز) عبارت بعد\n" +
                "[عبارت داخل کروشه] عبارت بعد\n" +
                "عبارت “داخل گیومه”");

        testStrings.add("استفاده از علائم ساده\u200Cی ریاضی\n" +
                "یکی دیگر از نشانه\u200Cهایی که به استفاده از آن\u200Cها احتیاج پیدا خواهید کرد علامت\u200Cهای ساده\u200Cی ریاضی مانند: + – *  / ٪ هستند، به یاد داشته باشید علامت درصد باید به عدد قبلی خود چسبیده باشد (بدون فاصله) ولی قبل و بعد از علامت\u200Cهای +، – و … فاصله ایجاد کنید.\n" +
                "نحوه\u200Cی صحیح به این صورت است:\n" +
                "۸۵٪\n" +
                "۲ + ۳\n" +
                "Shift + Enter\n" +
                "رعایت نکات بالا باعث میشود جملات تایپ شده در رایانه به صورت صحیح در تمام صفحات نمایش داده شوند (چراکه کامپیوتر با هر فاصله\u200Cای کلمه\u200Cی قبل و بعد را دو کلمه\u200Cی واحد و مجزا به حساب می\u200Cآورد و این امکان وجود دارد که بخشی از کلمه یا علامت آن به سطر بعدی منتقل شود، همچنین توجه داشته باشید که نیم\u200Cفاصله نیز به همین صورت عمل میکند، اگر با نیم فاصله آشنا نیستید این آموزش را ببینید: آموزش تصویری درج نیم\u200Cفاصله در مایکروسافت ورد)");

        testStrings.add("برای وارد كردن اعداد كسری مانند ¼، ½ و ¾ كه در كیبوردهای كامپیوتر دیده نمی شوند می توان به ترتیب كدهای Alt0188, Alt0189, Alt0190 را به كار برد. برای تایپ اعداد حتماً باید از قسمت Numeric Pad كه در سمت راست كیبورد قرار گرفته است استفاده شود.");
        testStrings.add("13) جابجایی متن: با ترفند زیر به راه حلی راحت و سریع برای كپی و یا جابجایی قسمتی از متن دست خواهید یافت: ابتدا متن و یا گرافیكی را كه تصمیم به حركت آن دارید علامت گذاری كنید. صفحه تصویر را با كمك حاشیه\u200Cهای آن كه در سمت راست و گوشه قابل حركتند. به قدری جابجا كنید كه مكانی را كه می\u200Cخواهید عنصر مربوطه به آن اضافه شود كاملا در دید قرار بگیرد. سپس برای جابجایی دكمه <Ctrl> و برای كپی كردن تركیب دكمه\u200Cهای <Ctrl>-<Shift> را كلیك كرده و با دكمه راست موش بر روی مقصد كلیك كنید.");
        testStrings.add("15) بایگانی فایل : اینكه نرم\u200Cافزار Word چه پوشه\u200Cای را به صورت استاندارد در زمان استفاده از گزینه\u200Cهای File->Open یا File->Save نشان می\u200Cدهد می\u200Cتوانید شخصا تعیین كنید تنظیمات مربوطه را می\u200Cتوانید در Tools->Options->File locations->Documents بیابید. اینكه فایل\u200Cهایی را كه شخصا درست كرده و به صورت الگو در آورده\u200Cاید در كجا ثبت می\u200Cشوند، نیز در همان بخش، قسمت User templates قابل مشاهده\u200Cاند. نرم\u200Cافزار Word هنگامی كه شما برای ذخیره نوع فایلی DOT را انتخاب كنید از این دایركتوری استفاده می\u200Cكند.\n" +
                "توسط دكمه Modify در همان بخش می\u200Cتوانید تنظیمات مربوطه را تغییر داده و تعیین كنیدكه برای مثال\u200C فایل\u200Cهای DOT و DOC در كجا ذخیره شوند. \n");
        testStrings.add(" نوشته شده توسط تيم توسعه سيفا\n" +
                " دسته: main-contents\n" +
                " منتشر شده در 05 شهریور 1394\n" +
                " بازدید: 1145");
        testStrings.add("جهت ارائه هرگونه پیشنهادات و انتقادات در مورد این سایت و کدهای خدماتی  118 - 20119 - 191 - 192 - 20126   میتوانید با شماره تلفن 20196 تماس بگیرید .");
        testStrings.add("1. تاریخ را به فرمت تاریخ میلادی بنویسیم ولی در قسمت format cell>custom فرمت ان را به صورت yy/mm/ddنوشت در این حالت تاریخ 21/05/1987 به صورت 21/05/87دیده میشوددراین حالت تاریخها به راحتی مقایسه میشوند و فرمت اطلاعات هم تاریخ هست و لی از نظر محاسبات روی تاریخ مشکل داریم مثلا ما تاریخ 31/03/87در تاریخ شمسی داریم ولی در تاریخ میلادی این تاریخ وجود ندارد چون ماه 3 انها 31 روزه نمیباشد و مشکل دوم اگر از توابع فاصله بین 2 تاریخ استفاده کنیم جواب با خطائ روبرو میشود.");
        testStrings.add("یک باگ جالب در مورد فرمول dayweek هست. این فرمول قرار است روز هفته یک تاریخ مشخص را برگرداند. طبق بررسی من، از امروز به عقب تا تاریخ 1380/10/11 (سه شنبه) این فرمول درست کار می کند ولی روز قبلش را اشتباه نشان می دهد");
        testStrings.add("شماره درخواست: 101033");
        testStrings.add("کیلومتر 20 جاده قدیم کرج-شهر قدس-بلوار انقلاب-خ رازی-پ 40-کدپستی 6816877889");
        testStrings.add("تلفن: 021-46467878 ، 021-98743200");
        testStrings.add("فکس: 021-09097676");
        testStrings.add("شماره ثبت/شماره ملی: 115361");
        testStrings.add("کد پستی 10 رقمی: 1399837711");
        testStrings.add("تلفن:88800892(تلفن شکایات و پیشنهادات: 88917049)");
        testStrings.add("تاریخ ویزیت: 1395/07/06              نوع پرداخت : نقدی");
        testStrings.add("نام خریدار: پوراحمدی، (مسجد سجاد) کد خریدار: 2011574");
        testStrings.add("نام فروشنده: 20725- بهمن حسنی");
        testStrings.add("ردیف |     شرح کالا      |    تعداد   |   بهای کل    |   تخفیفات | اضافات |");
        testStrings.add("1  |   شربت پرتقال14   |   2   |  1392528  |  0)0.0(  | 125326 |");
        testStrings.add("============================================================================");
        testStrings.add("جمع کل: 278560056 جمع اضافات: 250652 جمع تخفیفات: 0.0");
        testStrings.add("2 || شربت پرتقال13      2 || 139538  || 0(12.346%)  || 125326");

        int counter = 1;
        for (String input : testStrings) {
            System.out.println("Text " + counter + " : \t\t\t" + input);
            String result = PersianFormatterUtil.reverseNumberAndNonPersianCharacters(input);
            String result1 = PersianFormatterUtil.reverseNumberAndNonPersianWords(result);
            System.out.println("Reversed OrgText " + counter + " : \t" + result);
            System.out.println("Reversed RevText " + counter + " : \t" + result1);
            counter++;
            System.out.println("---------------------------------------");
        }
    }
}
