package uz.gita.test.controller;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import uz.gita.test.data.TestData;
import uz.gita.test.data.UserAnswerData;

public class AppController {
    public List<TestData> tesList;
    public List<UserAnswerData> userAnswerDataList;
    private int correctAnswer;
    private int wrongAnswer;
    private int currentPosition;
    private static AppController appController;

    public static AppController getInstance() {
        if (appController == null) appController = new AppController();
        return appController;
    }

//    public void setTesList(List<TestData> tesList) {
//        this.tesList = tesList;
//    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setWrongAnswer(int wrongAnswer) {
        this.wrongAnswer = wrongAnswer;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }


    private AppController() {
        tesList = new ArrayList<>();
        userAnswerDataList = new ArrayList<>();
    }

    public TestData getNextQuestion() {
        return tesList.get(currentPosition);
    }

    public void loadTest(int n) {
        switch (n) {
            case 0:
                tesList.add(new TestData("Sonnning kvadrati?", "4*4", "4:4", "4*0", "4*1", "4*4"));
                tesList.add(new TestData("Mukammal sonni toping", "1", "3", "5", "6", "6"));
                tesList.add(new TestData("5! soni 4! sonidan necha marta katta ?", "4/5", "4", "5", "1", "5"));
                tesList.add(new TestData("1 metr taqriban necha dyum ekanligini bilasizmi ?", "37", "40", "45", "39", "39"));
                tesList.add(new TestData("Aylananing diametei 28 uning radiusini toping !", "56", "14", "28", "20", "14"));
                tesList.add(new TestData("456° qaysi chorakda joylashgan ? ", "1", "2", "3", "4", "2"));
                tesList.add(new TestData("Yoyiq burchakning gradus o'lchovi nechiga teng ?", "90", "180", "360", "30", "180"));
                tesList.add(new TestData("Haqiqiy sonlar to'plami qanday harf bilan belgilani ?", "N", "R", "C", "H", "R"));
                tesList.add(new TestData("0! Nechiga teng? ", "0", "1", "Mavjud emas", "10", "1"));
                tesList.add(new TestData("-10 sonining 10% nechi teng? ", "-1", "-10", "-0.110", "Aniqlab bo'lmaydi", "Aniqlab bo'lmaydi"));
                tesList.add(new TestData("Trillionda nechta 0 bo'ladi ?", "9", "12", "15", "18", "12"));
                tesList.add(new TestData("Agar 9 ta ot 3 kunda 27 halta arpani yesa, 5 ot uchun 5 kunga nechchi halta arpa kerak bo'ladi ?", "26", "25", "15", "20", "25"));
                tesList.add(new TestData("1 dan 17gacha boʻlgan sonlarning nechtasi tub?", "8", "9", "7", "5", "7"));
                tesList.add(new TestData("Uchburchakning uchala burchagini kesib tashlasak u qanday shaklga aylanadi?", "To'rtburchak", "Beshburchak", "Oltiburchak", "Aylana", "Oltiburchak"));
                tesList.add(new TestData("«Riyoziyot» bu atama hozirda qanday ataladi?", "Matemetika", "Beshburchak", "Oltiburchak", "Aylana", "Oltiburchak"));
                tesList.add(new TestData("Sonning nimchoragi 10 boʻlsa,shu sonning oʻzini toping.", "80", "40", "20", "30", "80"));
                tesList.add(new TestData("Ikkita toq sonning yig'indisi 5 ga boʻlinadi. Bu sonlar kublarining yig'indisi qanday raqam bilan tugaydi?", "6", "5", "4", "0", "0"));
                tesList.add(new TestData("Natural sonni 18 ga boʻlganda boʻlinma 19ga , qoldiq 8 ga teng boʻladi boʻlinuvchini toping.", "243", "263", "273", "350", "350"));
                tesList.add(new TestData("Uchburchakning tashqi burchaklari yig‘indisini toping.", "0", "360", "720", "180", "360"));
                tesList.add(new TestData("Uchburchakning ichki burchaklari yig‘indisini toping.", "0", "360", "720", "180", "180"));
                tesList.add(new TestData("y, 3y+5 , 5y+10, ..... arifmetik progressiyaning dastlabki 8 ta xadi yig'indisi 396 ga teng.Uning qiymatini toping", "4", "6", "2", "5", "4"));
                tesList.add(new TestData("sin² a+2 cos² a ning eng katta qiymatini toping ", "1.2", "1.4", "1.6", "2", "2"));
                tesList.add(new TestData("f (x)=3x-x³ funksiyaning maksimumini toping", "-1", "-2", "2", "4", "2"));
                tesList.add(new TestData("√225+15-1=?", "38", "43", "29", "10", "29"));
                tesList.add(new TestData("50% i 200 ga teng sonni toping.", "400", "100", "200", "800", "400"));
                tesList.add(new TestData("7⁰×6²+√4×3²×2²+4²-2=?", "122", "132", "225", "Aniqlab bo'lmaydi", "122"));
                tesList.add(new TestData("(7+7+7+7+7+7+7+7+7+1)×√25+80=?", "780", "400", "300", "188", "400"));
                tesList.add(new TestData("47⁴⁵ ni 10 ga boʻlgandagi qoldiqni toping.", "7", "1", "9", "0", "7"));
                tesList.add(new TestData("Ushbu 43⁴³ -17¹⁷ ayirmani 10 ga boʻlganda xosil boʻladigan qoldiqni toping.", "5", "2", "1", "0", "0"));
                tesList.add(new TestData("y=x⁵. Funksiyaning ekstremum nuqtalarini toping.", "(0;0)", "Ekstremumi yo'q", "(1;1)", "(1;-1)", "Ekstremumi yo'q"));
                tesList.add(new TestData("√324=?", "23", "18", "16", "28", "18"));
                tesList.add(new TestData("Tekis tezlanuvchan harakat qila boshlagan jism 4s da 20 metr masofani bosib oʻtsa u qanday tezlikka erishgan?", "5", "10", "15", "20", "10"));
                tesList.add(new TestData("x sonini ketma ket 20% ga oshirsak x soni necha foizga oshadi?", "20", "50", "40", "44", "44"));
                tesList.add(new TestData("36 va 48 ning ekubini toping.", "14", "24", "12", "23", "12"));
                tesList.add(new TestData("x²-2x+1=0", "1", "0 va 1", "0", "Tjy", "1"));
                tesList.add(new TestData("Soddalashtiring. \n a(b-c)+b(c-a)-c(b-a)", "421", "441", "23", "347", "441"));
                tesList.add(new TestData("(7×3)²=", "421", "441", "23", "347", "441"));
                tesList.add(new TestData("(7×3)²=", "421", "441", "23", "347", "441"));
                tesList.add(new TestData("36 yoshdagi onaning yoshi 4 ta bolalarning yoshlari yig'indisidan 3 marta ortiq. Necha yildan soʻng onaning yoshi bolalarning yoshlarining yig'indisiga teng boʻladi?", "7", "8", "9", "10", "8"));
                tesList.add(new TestData("Uchburchakning nechta o‘rta chizig‘i bor?", "1", "3", "2", "0", "3"));
                tesList.add(new TestData("3000 soʻmlik kartoshkadan 2 kg, 2000 soʻmlik piyozdan 3 kg olindi. 1 kg sabzavot necha soʻmdan tushgan?", "2400", "1000", "2500", "3000", "2400"));
                tesList.add(new TestData("x²-2x-1=0 tenglamaning ildizlari a va b boʻlsa, a⁴+b⁴ ni toping.", "6", "34", "36", "38", "36"));
                tesList.add(new TestData("Agar x²+x–1=0 tenglamaning ildizlari x₁ va x₂ bo'lsa, x₁³+x₂³ ning qiymati qanchaga teng bo'ladi?", "2", "4", "-2", "-4", "-4"));
                tesList.add(new TestData("0,23 qismi 690 ga teng sonni toping", "3000", "2500", "3200", "3500", "3000"));
                tesList.add(new TestData("Bir quyon daryo tomon ketayotganida 6 ta filni ko'rdi. Har bir fil daryo tomon ketayotgan 2 ta maymunni ko'rdi. Har bir maymun qo'lida bittadan toshbaqa bor edi.  Hammasi nechta hayvon daryo tomon ketyapti?", "12", "10", "8", "5", "5"));
                tesList.add(new TestData("O'quvchi berilgan 56 ta savoldan 30 tasini yechdi. Bulardan 10 tasini no'to'g'ri yechdi. O'quvchi qolgan savollardan nechtasini to'g'ri yechsa, umumiy savollaring 75% ini to'g'ri yechadi?", "18", "22", "26", "24", "22"));
                tesList.add(new TestData("Qopda 4ta yashil, 3ta qora toshlar bor. 1ta tosh olinganda ko'k yoki yashil chiqish ehtimoli?", "1/7", "4/7", "2/7", "3/7", "4/7"));
                tesList.add(new TestData("Umarning misolni to'g'ri ishlash ehtimoli 0,8ga, Sherzodniki esa 0,4ga teng bo'lsa, kamida bittasini yecha olish ehtimoli qanchaga teng?", "32%", "56%", "88%", "67%", "88%"));
                tesList.add(new TestData("Bir son ikkinchisidan  40 taga ortiq. Birinchi sonning 20%i ikkinchi  sonning 10%i dan 1 taga ortiq. Shu sonlarni toping?", "90 va 130", "30 va 90", "50 va 90", "60 va 200", "50 va 90"));
                break;
            case 1:
                tesList.add(new TestData(" Amir Temur davlatining poytaxti bo‘lgan shaharni toping.", "Samarqand", "Kesh", "Buxoro", "Shosh", "Samarqand"));
                tesList.add(new TestData(" XIV asrda Chig‘atoy xonlaridan kim birinchi bo‘lib o‘z qarorgohini Movarounnahrga ko‘chirgan?", "Kebek", "Munke", "Tug‘luq Temur", "Abulxayrxon", "Kebek"));
                tesList.add(new TestData(" O‘zbekiston hududidagi qaysi manzilgohda ilk shahar alomatlari ko‘zga tashlanadi?", "Obishir", "Ko‘lbuloq", "Selengur", "Jarqo‘ton", "Jarqo‘ton"));
                tesList.add(new TestData(" Rus podshosi Ivan IV bilan elchilik aloqalarini o‘rnatgan Buxoro xonini toping", "Ko‘chkunchixon", "Ubaydullaxon", "Abdullaxon II", "Imomqulixon", "Abdullaxon II"));
                tesList.add(new TestData("  Toshkent shahri kim boshchiligidagi podsho Rossiyasi qo‘shinlari tomonidan egallangan? (1865-yil)", "fon Kaufman", "M.Chernyayev", "F.Romanovskiy", "M.Skobelev", "M.Chernyayev"));
                tesList.add(new TestData(" Rossiya imperiyasi tarkibidagi Turkiston general-gubernatorligi nechanchi yilda tashkil etilgan?", "1875-yilda", "1867-yilda", "1856-yilda", "1881-yilda", "1867-yilda"));
                tesList.add(new TestData(" Sovetlar boshqaruvi davrida o‘zbek xotin-qizlarini ozodlikka chiqarish jarayoni qanday nom ostida o‘tkazilgan?", "“Ozodlik” harakati", "Kolxozchilar” harakati", "“Hujum” harakati", "“Bosmachilik” harakati", "“Hujum” harakati"));
                tesList.add(new TestData(" 1993-yilda O‘zbekiston qaysi xalqaro tashkilotga a’zo bo‘lgan?", "YuNESKO ", "ShHT", "MDH", "BMT", "YuNESKO "));
                tesList.add(new TestData(" O‘zbekiston Respublikasida ijro etuvchi hokimiyat hisoblanadigan organni toping.", "Oliy Sud", " Konstitutsiyaviy sud", "Oliy Majlis", "Vazirlar Mahkamasi", "Vazirlar Mahkamasi"));
                tesList.add(new TestData(" Qaysi daryo qadimda Yaksart deb atalgan?", "Qashqadaryo", "Zarafshon", "Sirdaryo", "Amudaryo", "Sirdaryo"));
                tesList.add(new TestData(" XIX asrning o‘rtalarida Toshkent shahrining nechta darvozasi bo‘lgan?", "9 ta", "12 ta", "6 ta", "14 ta", "12 ta"));
                tesList.add(new TestData(" Ikkinchi jahon urushi yillarida O‘zbekistonning qaysi shahrida metallurgiya zavodi bunyod etilgan?", "Navoiy", "Buxoro", "Bekobod", "Qo‘qon", "Bekobod"));
                tesList.add(new TestData(" VI-VII asrlarda O‘rta Osiyo aholisining asosiy qismi qaysi dinga e’tiqod qilgan?", "nasroniylik", "buddaviylik", "zardushtiylik", "moniylik", "zardushtiylik"));
                tesList.add(new TestData(" XIX asr boshida qaysi hukmdorning hukmronligi davrida Qo‘qon adabiy muhiti shakllangan?", "Xudoyorxon", "Umarxon", "Erdonabiy", "Sheralixon", "Umarxon"));
                tesList.add(new TestData("Vazirlar Mahkamasining 1997-yildagi qarori bilan har ikki yilda bir marotaba qaysi shaharda “Sharq taronalari” xalqaro musiqa festivali o‘tkazilib kelinmoqda?", "Samarqand", "Buxoro", "Qo‘qon", "Shosh", "Samarqand"));
                tesList.add(new TestData("O’rta asrlarda yurtimiz qanday nomlar bilan nomlangan?", "Buxoro, Xiva, Qo’qon", "Turon, Turkiston, Movarounnahr", "Turkiya, Turkiston", "Turon, Movarounnahr, Xuroson", "Turon, Turkiston, Movarounnahr"));
                tesList.add(new TestData("XIV asrda Buxoroda tasavvufning qanday tariqati vujudga kelgan?", "Naqshbandiya va Kubraviya", "Naqshbandiya", "Yassaviya", "Kubraviya", "Naqshbandiya"));
                tesList.add(new TestData("Ilk o‘rta asrlarda dehqon atamasi qanday ma’noda ishlatilgan?", "Yerga ishlov beruvchi erkin ishchi", "Qishloq hokimi", "Ijaraga yer olib ishlovchi qaram tabaqa", "Katta yer egasining mulkini qo‘riqlovchi", "Qishloq hokimi"));
                tesList.add(new TestData("Xioniylar davlati qaysi asrlarda hukmronlik qilgan? ", "IV asrning 20-yillari—V asrning 70-yillari", "IV asrning 50-yillari—VI asrning 2-yarmi", "IV asrning 70-yillari—V asrning 2-yarmi", " V asrning 70-yillari—VI asrning 2-yarmi", "IV asrning 70-yillari—V asrning 2-yarmi"));
                tesList.add(new TestData("Buxoro IX asrdan boshlab qanday nom bilan shuhrat topadi? ", "“Sayqali ro‘yi zamin”", "“Faqihlar shahri”", "“Qubbat ul-islom”", "“Ming gumbaz shahri”", "“Qubbat ul-islom”"));
                tesList.add(new TestData("Milodiy III asrda Xorazm davlatining poytaxti qadimgi qaysi shahar xarobasining o‘rnida bo‘lgan?", "Jonbosqal’a", "Jarqo‘ton", "Jarqo‘ton", "Turoqqal’a", "Turoqqal’a"));
                tesList.add(new TestData("Boshini dorga tikkanlar, mo‘g‘ul-lar zulmiga qarshi xalq qo‘zg‘oloni qatnashchilari qaysi nom bilan atalgan? ", "sarbadorlar", "sarkorlar", "sohibqironlar", "tudunlar", "sarbadorlar"));
                tesList.add(new TestData("Afrig’iylar nechanchi asrlarda hukmronlik qilgan?", "III-X asrlar", "IV-X asrlar", "V-XV asrlar", "IV-IX asrlar", "III-X asrlar"));
                tesList.add(new TestData("Qachon Amir Temurning hukm-dorligi rasman tan olinib, u Movarounnahrning amiri deb e’lon qilinadi?", "1370-yilning 11 aprelida", "1360-yilning 10-aprelida", "1365-yilning 22-mayida", "1375-yilning 10-iyulida", "1360-yilning 10-aprelida"));
                tesList.add(new TestData("V-VI asrlarda O’rta Osiyoda aholi qaysi tilda so’zlashgan?", "arab va fors", "turk va sug’d", "xorazm va eftal", "turk, xorazm", "arab va fors"));
                tesList.add(new TestData("Mahmud Zamaxshariyning arab tili fonetikasi va morfo-logiyasiga bag‘ishlangan asari qanday nom-lanadi?", "“Al-Mufassal’", "““Al-Jomi” as-sahih”", "“Hidoya’", "“Al-Kashshof”", "“Al-Mufassal’"));
                tesList.add(new TestData("Amir Temur saltanatida ijroiya hokimiyat — devonni kim boshqargan?", "qo‘shbegi", "Oliy hukmdorning o‘zi", "amir", "devonbegi (bosh vazir)", "devonbegi (bosh vazir)"));
                tesList.add(new TestData("IX-X asrlarga mansub “Buxoro tarixi” asari muallifi kim?", "Narshaxiy", "Ibn Xavqal", "Ishtaxriy", "Juvayniy", "Narshaxiy"));
                tesList.add(new TestData("Qachon Kubroning 850 yilligi nishonlandi?", "1996-yili", "1995-yili", "1998-yili", "2000-yili", "1995-yili"));
                tesList.add(new TestData("Ulug‘bek Movarounnahrni necha yil idora qildi? ", "yigirma yil", "o‘ttiz yil", "qirq yil", "ellik yil", "qirq yil"));
                tesList.add(new TestData("Siyrat as-sulton Jalol ad-Din Mengburni”asari muallifi kim?", "Ibn Kasir", "Sharofulmulk", "Nasaviy", "Ibn Arabshoh", "Nasaviy"));
                tesList.add(new TestData("Temuriylar davrida sug‘orma dehqonchilik yerlaridan olinadigan asosiy soliq nima deb atalgan? ", "ushr", "xiroj", "zakot", "begor", "xiroj"));
                tesList.add(new TestData("Qaysi hukmdor o‘z qarorgohini mo‘g‘ul hukmdorlari orasida birinchi bo‘lib Movarounnahrga ko‘chiradi? ", "Chig‘atoy", "Kebekxon", "Munke", "Jo‘ji", "Kebekxon"));
                tesList.add(new TestData("O‘rta Osiyo hududida aholi islom diniga nechanchi asrdan buyon e‘tiqod qilib kelmoqda? ", "VIII asrdan ", "VII asrdan", "VI asr oxiridan ", "IX asr o‘rtalarida", "VIII asrdan "));
                tesList.add(new TestData("Turkman, ozarbayjon va qoraqalpoqlarning etnogenizida muhim ahamiyat oynagan turkiy xalqni ko‘rsating. ", "saljuqiylar", "qarluqlar", "o‘g‘uzlar", "g‘aznaviylar", "qarluqlar"));
                tesList.add(new TestData("1420-yillarda Ulug‘bek farmoni bilan qayerda madrasa quriladi?", "Buxoroda", "Hirotda", "G‘ijduvonda", "Samarqandda", "Samarqandda"));
                tesList.add(new TestData("Qang‘ davlati davriga oid qaysi madaniy yodgorlik turkiyzabon etnoslar shakllanishda muhim rol o‘ynagan? ", "O‘rta Osiyo madaniyati ", "Qang’ madaniyati", "Turk madaniyati", "Qovunchi madaniyati", "Qang’ madaniyati"));
                tesList.add(new TestData("Ismoil Somoniy butun Movaro-unnahr va Xurosonni o‘z qo‘li ostida birlashtirgandan so‘ng qaysi shaharni poytaxt deb e’lon qildi?", "Samarqandni", "Xurosonni", "Tarozni", "Buxoroni", "Buxoroni"));
                tesList.add(new TestData("Al-Farg‘oniy Yevropada qanday taxallus bilan shuhrat qozongan?", "Algoritm", "Alfraganus", "Avitsenna", "Shayx-ur-Rais", "Alfraganus"));
                tesList.add(new TestData("Sharqda mashhur bo‘lgan “zandanacha” va “vadoriy” matolari qayerlarda tayyorlangan?", "Binkat va Keshda ", "Urganch va Marvda", "Buxoro va Samarqandda", "Axsikat va Binkat", "Buxoro va Samarqandda"));
                tesList.add(new TestData("Mashhur matematik va astronomlardan qay biri Aflotuni zamon deb nom olgan? ", "Qozizoda Rumiy", "G‘iyosiddin Jamshid Koshoniy", "Shamsiddin Muhammad Havofiy", "Ali Qushchi", "Qozizoda Rumiy"));
                tesList.add(new TestData("Mag‘oki attori masjidi nechanchi asrga oid? ", "XII asr ", "XIII asr", "XI asr", "X asr", "XII asr"));
                tesList.add(new TestData("Qaysi sulola davrida o‘zbek xalqining  shakllanishi yakuniy bosqich bo‘ldi? ", "Shayboniylar", "Temuriylar", "Qoraxoiylar", "Somoniylar", "Qoraxoiylar"));
                tesList.add(new TestData("Chingizxon qayerdan turib Samarqandni qamal qilish ishiga boshchilik qilgan? ", "Arkdan", "Bo‘stonsaroy", "Ko‘ksaroy", "Oqsaroy", "Arkdan"));
                tesList.add(new TestData("Amir Temur qachon Fransiya va Angliyaga maktublar yo‘llaydi? ", "1402-yil yozida ", "1403-yil mayda", "1403-yil yozida", "1404-yilning sentabr", "1402-yil yozida "));
                tesList.add(new TestData("XIII asr boshlarida Xorazm sharqdagi ulkan davlat edi. Bu ulkan davlatning poytaxti qaysi shahar bo‘lgan?", "Xiva", "Kat", "Urganch", "G’azna", "Urganch "));
                tesList.add(new TestData("720-yilda G’urak va Divashtich boshchiligida arablarga qarshi qayerda qo‘zg’olon ko‘tarildi?", "Buxoro", "Farg’onda", "Sug’dda", "Marvda", "Sug’dda"));
                tesList.add(new TestData("Movarounnahrda arablar joriy etgan hosilning 1/3 qismi hajmida olinadigan yer solig‘i nima deyilgan?", "xiroj", "ushr", "qopchur", "tanobona", "xiroj"));
                tesList.add(new TestData("Qarluqlar davlati qachon tashkil topgan?", "VIII asrda", "IX asrda", "X asrda", "VI asrda", "VIII asrda"));
                tesList.add(new TestData("Abbosiylar sulolasining hukmronlik yillarini aniqlang?", " 632-661-yilar", "661-1258-yillar", "661-750-yillar", "750-1258-yillar", "632-661-yilar"));
                tesList.add(new TestData("V-VII asrlarda budda haykali topilgan Quva mazilgohi qayerda joylashgan? ", "Farg’ona", "Samarqand", "Toshkent", "Buxoro", "Farg’ona"));
                tesList.add(new TestData("Juma namozida hukmdor nomini aytib uning haqiga duo o‘qish bu …?", "farz", "namoz", "xutba", "hadis", "xutba"));
                break;
            case 2:
                tesList.add(new TestData("Qaysi javobdagi so‘zlar imloviy jihatdan to‘g‘ri yozilgan?", "xususiyat, tafsilot", "daromad, sabzovot", "saxovot, zokovat", "halovat, forosat", "xususiyat, tafsilot"));
                tesList.add(new TestData("Qaysi javobdagi ajratib ko‘rsatilgan so‘z ko‘chma ma’noda qo‘llangan?", "shabadaning yugurishi", "qalin taxta", "tog‘ cho‘qqisi", "buloqning ko‘zi", "buloqning ko‘zi"));
                tesList.add(new TestData("Qaysi javobda ot turkumi doirasida o‘zaro shakldoshlik hosil qila oladigan so‘z berilgan?", "shoh", "afzal", "ot ", "qor", "ot "));
                tesList.add(new TestData("Qaysi javobda zid ma’noli so‘zlar juftligi berilgan?", "tor − keng ", "qalin − yo‘g‘on", "hiyla − xiyla", "xotirjam − bemalol", "tor − keng "));
                tesList.add(new TestData("Qaysi javobda tasviriy ifodaning izohi to‘g‘ri berilgan?", "kumush tola − makkajo‘xori", "o‘rmon qiroli − sher", "dala malikasi − paxta", "mo‘yqalam ustalari − shoirlar", "o‘rmon qiroli − sher"));
                tesList.add(new TestData("Qaysi javobda ot va sifat turkumiga oid juftlik berilgan?", "chiziq − qiliq", "chiroy − ko‘rk", "muattar − iforli", "sevgi − kuzgi", "sevgi − kuzgi"));
                tesList.add(new TestData("Otli so‘z birikmasi berilgan javobni aniqlang.", "ishni tezlatish", "chiroyli kiyingan", "bajarilgan ish", "akamni ko‘rmoq", "bajarilgan ish"));
                tesList.add(new TestData("Gap bo'laklari va gaplarni tobelantirib bog'lovchi, ular orasidagi shart ma'nosini ifodalovchi bog'lovchini toping.", "ya'ni", "balki", "garchi", "chunki", "garchi"));
                tesList.add(new TestData("chog'li, bo'ylab, kabi ko'makchilar qaysi kelishik shaklidagi so'zlarga qo'shiladi?", "bosh kelishigidagi", "qaratqich kelishigidagi", "jo'nalish kelishigidagi", "chiqish kelishigidagi", "bosh kelishigidagi"));
                tesList.add(new TestData("Qiy-chuv bilan ularni yengib bo'lmaydi. Ushbu gapda qaysi ikkinchi darajali gap bo'lagi qatnashgan?", "faqat to'ldiruvchi", "hol va to'ldiruvchi", "aniqlovchi va hol", "aniqlovchi va to'ldiruvchi", "hol va to'ldiruvchi"));
                tesList.add(new TestData("Gap qatnashgan qatorni toping.", "chiroyli gul", "muhandis akam", "gazalni yodlash", "gul chiroyli", "gul chiroyli"));
                tesList.add(new TestData("gap markazida bolib, u tasdiq-inkor, zamon, mayl, shaxs-son ma'nolarini ifodalab keladi, hukmni ifodalaydi va gapning boshqa bolaklarini oz atrofida birlashtiradi. Bu ta'rif qaysi bo`lakka tegishli?", "ega", "kesim", "ega va kesim", "aniqlovchi", "kesim"));
                tesList.add(new TestData("It tumshug'ini suqqani bilan daryo harom bo'lib qolmaydi, nomard tosh otgani bilan tog' qulab tushmaydi. Ushbu gapda qo'llangan so'zlarning nechtasi fonetik hodisaga uchragan?", "1 ta so'zda", "2 ta so'zda", "3 ta so'zda", "4 ta so'zda", "2 ta so'zda"));
                tesList.add(new TestData("Qaysi qatorda berilgan gap yig'iq gap emas?", "Barpo etilmoqda.", "Havas qilmoqda.", "Dovrug'i oshdi.", "Barchasi yig'iq gap.", "Barchasi yig'iq gap."));
                tesList.add(new TestData(" Rejani yana qaytadan ko'rib chiqishga to'g'ri keladi. Ushbu gap...", "shaxsi umumlashgan gap", "shaxsi noma'lum gap", "shaxsi ma'lum gap", "atov", "shaxsi noma'lum gap"));
                tesList.add(new TestData("Qaysi qatorda neytral leksikaga mansub so'zlar berilgan?", "bug'doy", "volidayi muhtarama", " shoti", "takya", "volidayi muhtarama"));
                tesList.add(new TestData("Qo'llanish doirasi chegaralangan so'zlar bu...?", "argolar", "jargonlar", "dialektizmlar", "A, B,C", "A, B,C"));
                tesList.add(new TestData("Quyida berilganlardan imloviy jihatdan xato yozilgan so'zlarni aniqlang. 1) tele koʻrsatuv; 2) taqiqlamoq; 3) hokandoz; 4) tushincha; 5) mas'ul; 6) hatti-harakat", "1, 3, 4, 6", "1, 2, 4, 5", "2, 4, 5, 6", "1, 3, 5, 6", "1, 3, 4, 6"));
                tesList.add(new TestData("Qaysi gapda yasama sifatning otlashishi kuzatiladi?", "Aqllilar o'z ishlarini bilib-bilib qilishadi", " Keksalar katta hayotiy tajribaga ega bo'ladilar", "Aybsiz do'st axtargan do'stsiz qolar", "Yaxshidan bog' qoladi, yomondan - dog'", "Aqllilar o'z ishlarini bilib-bilib qilishadi"));
                tesList.add(new TestData("O'g'lim, sen uzumini yegin-u, bog 'ini surishtirma. Ushbu gapda tarkibidagi barcha undoshlari jarangli til undoshlariga mansub boʻlgan so'z qanday sintaktik vazifa bajargan?", "undalma ", "kesim ", "ega", " toʻldiruvchi", "kesim "));
                tesList.add(new TestData("Achinish munosabatini ifodalovchi modal so'zni toping", "Xullas", "Albatta ", "Afsuski ", "Darhaqiqat", "Afsuski"));
                tesList.add(new TestData("Quyidagi gapda imloviy jihatdan xato yozilgan so'zlar soni nechta? G'azapdan o'zingni asra, chunki u tufayli inson ishlarini, ezgu maqsatlarini unitadi", "4ta", "3ta", "2ta", "1ta", "3ta"));
                tesList.add(new TestData("O'smirlarimiz xalqaro turnirlarda g'alaba qozonmoqdalar. O'zbekning dovrug'ini olamga yoymoqdalar. Ushbu gapda yoymoq soʻzi qaysi maʼnoda qoʻllangan?", "Taxlangan, o'ralgan narsalami ochmoq.", " Kichik-kichik guruhlarga bo'linib ketmoq.", "Mashhur qilmoq, ovoza qilmoq.", "Tevarak-atrofga anqimoq.", "Mashhur qilmoq, ovoza qilmoq."));
                tesList.add(new TestData("Ijodkor yoshlar, tajriba asosida, o'q ildiz. Ushbu so'z birikmalari qaysi uslubga xosdir?", "rasmiy uslub", "so'zlashuv uslubi", "ilmiy uslub", "publitsistik uslub", "ilmiy uslub"));
                break;

        }
    }

    public void shuffleTests() {
        Collections.shuffle(tesList);
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public int getWrongAnswer() {
        return wrongAnswer;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void check(String answer) {
        if (answer.equals(tesList.get(currentPosition).getAnswer())) {
            userAnswerDataList.add(new UserAnswerData(answer, true, false));
            correctAnswer++;
        } else {
            userAnswerDataList.add(new UserAnswerData(answer, false, false));
            wrongAnswer++;
        }
        currentPosition++;
    }

    public void skip() {
        userAnswerDataList.add(new UserAnswerData(tesList.get(currentPosition).getAnswer(), false, true));
        wrongAnswer++;
        currentPosition++;
    }
}
