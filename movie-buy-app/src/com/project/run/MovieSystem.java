package com.project.run;

import com.project.bean.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MovieSystem {
    /*
定义系统的数据容器用户存储数据
1、存储很多用户（客户对象，商家对象）
 */
    public static List<User> ALL_USERS;
    /*
    2、存储系统全部商家和其他排片信息
    商家1 = 【p1,p2,p3】
    商家2 =  [p2,p3]
     */
    public static final Map<Busicess, List<Movie>> ALL_MOVIES = new HashMap<>();

    //定义一个静态的User类型的遍历记住当前登陆成功的用户对象
    public static User loginUser;
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final Logger LOGGER =  LoggerFactory.getLogger(MovieSystem.class);

    static {
        ALL_USERS = new ArrayList<>();
        Customer c = new Customer();
        c.setLoginName("hhh666");
        c.setPassWord("123456");
        c.setUserName("刘德华");
        c.setSex('男');
        c.setMoney(10000);
        c.setPhone(10086);
        ALL_USERS.add(c);

        Customer c1 = new Customer();
        c1.setLoginName("mao999");
        c1.setPassWord("123456");
        c1.setUserName("徐世茂");
        c1.setSex('女');
        c1.setMoney(2000);
        c1.setPhone(10010);
        ALL_USERS.add(c1);

        Busicess b1 = new Busicess();
        b1.setLoginName("jjj999");
        b1.setPassWord("123456");
        b1.setUserName("老毕灯");
        b1.setSex('男');
        b1.setMoney(0);
        b1.setPhone(10000);
        b1.setAddress("火星6号2B二层");
        b1.setShopName("甜甜圈国际影城");
        ALL_USERS.add(b1);

        List<Movie> movies = new ArrayList<>();
        ALL_MOVIES.put(b1,movies);

        Busicess b2 = new Busicess();
        b2.setLoginName("li123");
        b2.setPassWord("123456");
        b2.setUserName("八毛货");
        b2.setSex('男');
        b2.setMoney(0);
        b2.setPhone(95500);
        b2.setAddress("金星9号3C三层");
        b2.setShopName("巨人城在线影城");
        ALL_USERS.add(b2);

        ALL_MOVIES.put(b2,movies);
    }

    public static final Scanner SYS_SC = new Scanner(System.in);

    public static void main(String[] args) {
        showMain();
    }

    private static void showMain() {
        System.out.println("============老狗电影首页============");
        System.out.println("1、登陆");
        System.out.println("2、用户注册");
        System.out.println("3、商家注册");
        while (true) {
            System.out.println("请输入操作命令:");
            String commend = SYS_SC.nextLine();
            switch (commend){
                case "1":
                    login();
                    break;
                case "2":
                    System.out.println("对不起，该功能暂未开通！");
                    break;
                case "3":
                    System.out.println("对不起，该功能暂未开通！");
                    break;
                default:
                    System.out.println("命令有误，请确认!");
            }
        }
    }

    private static void login() {
        while (true) {
            System.out.println("请输入登陆名：");
            String loginName = SYS_SC.nextLine();
            System.out.println("请输入登陆密码：");
            String passWord = SYS_SC.nextLine();

            //根据登陆名称查询用户名称
            User u = getUserByLoginName(loginName);

            //判断登陆名是否正确
            if (u != null){
                //对比密码是否正确
                if (u.getPassWord().equals(passWord)){
                    loginUser = u;  //记住登陆成功的用户
                    LOGGER.info(u.getUserName()+"登陆了系统");
                    //判断是用户登陆的还是商家登陆的
                    if (u instanceof Customer){
                        //展示用户界面
                        showCusrtomerMain();
                    }else {
                        //展示商家界面
                        showBusinessMain();
                    }
                    return;
                }else {
                    System.out.println("密码输入错误！");
                }
            }else {
                System.out.println("登陆名错误，请重新输入！");
            }
        }
    }

    //商家操作界面
    private static void showBusinessMain() {
            System.out.println("=============老狗电影商家界面=============");
            System.out.println(loginUser.getUserName() + (loginUser.getSex() == '男'? "先生":"女士" + "欢迎您进入系统"));
            System.out.println("1、展示详情");
            System.out.println("2、上架电影");
            System.out.println("3、下架电影");
            System.out.println("4、修改电影");
            System.out.println("5、退出系统");

            System.out.println("请输入你要操作的命令：");
            String commend = SYS_SC.nextLine();

            switch (commend){
                case "1":
                    showBusinessinfors();
                    break;
                case "2":
                    addMovie();
                    break;
                case "3":
                    deleteMovie();
                    break;
                case "4":
                    updateMovie();
                    break;
                case "5":
                    System.out.println(loginUser.getUserName()+"欢迎下次光临！");
                    return;
                default:
                    System.out.println("输入的命令有误，请重新输入！");
            }
    }

    private static void updateMovie() {
        System.out.println("==============下架电影==============");
        Busicess busicess = (Busicess) loginUser;
        List<Movie> movies = ALL_MOVIES.get(busicess);

        if (movies.size() == 0){
            System.out.println("当前没有可修改的电影！");
            return;
        }

        while (true) {
            System.out.println("请您输入需要修改的片名：");
            String movieName = SYS_SC.nextLine();
            //查询有没有这个影片对象
            Movie movie = getMovieByName(movieName);
            if(movie != null){
                System.out.println("请您输入修改后的片名：");
                String name = SYS_SC.nextLine();
                System.out.println("亲您输入修改后主演：");
                String actor = SYS_SC.nextLine();
                System.out.println("亲您输入修改后时长：");
                String time = SYS_SC.nextLine();
                System.out.println("请您输入修改后票价：");
                String price = SYS_SC.nextLine();
                System.out.println("请您输入修改后票数：");
                String totalNumber = SYS_SC.nextLine();

                try {
                    System.out.println("请您输入修改后的影片放映时间：");
                    String stime = SYS_SC.nextLine();
                    movie.setName(name);
                    movie.setActor(actor);
                    movie.setPrice(Double.valueOf(price));
                    movie.setTime(Double.valueOf(time));
                    movie.setStartTime((Date) sdf.parse(stime));
                    movie.setNumber(Integer.valueOf(totalNumber));
                    System.out.println("您成功修改了该影片!");
                    showBusinessinfors();
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    LOGGER.error("时间解析有问题！");
                }
            }else {
                System.out.println("您的店铺没有上架该影片！");
            }
        }
    }

    private static void deleteMovie() {
        System.out.println("==============下架电影==============");
        Busicess busicess = (Busicess) loginUser;
        List<Movie> movies = ALL_MOVIES.get(busicess);

        if (movies.size() == 0){
            System.out.println("当前没有可下架的电影！");
            return;
        }
        while (true) {
            System.out.println("请您输入需要下架的片名：");
            String movieName = SYS_SC.nextLine();

            //查询有没有这个影片对象
            Movie movie = getMovieByName(movieName);
            if(movie != null){
                movies.remove(movie);
                System.out.println("您当前颠覆已经成功下架了："+movie.getName());
                return;
            }else {
                System.out.println("您的店铺没有上架该影片！");
            }
        }

    }
    public static Movie getMovieByName(String movieName){
        Busicess busicess = (Busicess) loginUser;
        List<Movie> movies = ALL_MOVIES.get(busicess);
        for (Movie movie : movies){
            if (movie.getName().contains(movieName)){
                return movie;
            }
        }
        return null;
    }

    private static void addMovie() {
        System.out.println("==============上架电影==============");
        //根据商家对象（就是登陆的用户loginUser），作为Map集合的键 提取对应的值就是其排片信息
        Busicess busicess = (Busicess) loginUser;
        List<Movie> movies = ALL_MOVIES.get(busicess);

        while (true) {
            System.out.println("请您输入新片名：");
            String name = SYS_SC.nextLine();
            System.out.println("请您输入主演：");
            String actor = SYS_SC.nextLine();
            System.out.println("请您输入时长：(单位min)");
            String time = SYS_SC.nextLine();
            System.out.println("请您输入票价：");
            String price = SYS_SC.nextLine();
            System.out.println("请您输入票数：");
            String totalNumber = SYS_SC.nextLine();

            System.out.println("请输入影片放映时间：");
            String stime = SYS_SC.nextLine();
            try {
                Movie movie = new Movie(name,actor,Double.valueOf(time),Double.valueOf(price),Integer.valueOf(totalNumber),sdf.parse(stime));
                movies.add(movie);
                System.out.println("您已经成功上架了：《"+movie.getName()+"》");
            } catch (ParseException e) {
                e.printStackTrace();
                LOGGER.error("时间解析出了错误！");
            }
        }
    }

    //用户操作界面
    private static void showCusrtomerMain() {
        while (true){
        System.out.println("=============老狗电影客户界面=============");
        System.out.println(loginUser.getUserName() + (loginUser.getSex() == '男'? "先生":"女士" + "欢迎您进入系统"+"\t余额"+loginUser.getMoney()));
        System.out.println("请选择你要操作的功能：");
        System.out.println("1、展示全部影片信息功能");
        System.out.println("2、根据电影名称查询电影信息");
        System.out.println("3、评分功能");
        System.out.println("4、购票功能");
        System.out.println("5、退出系统");

            System.out.println("请输入你要操作的命令：");
            String commend = SYS_SC.nextLine();
            switch (commend){
                case "1":
                    showAllMovie();
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    buyMovie();
                    break;
                case "5":
                    return;
                default:
                    System.out.println("输入的命令有误，请重新输入！");
            }
        }
    }

    private static void buyMovie() {
        showAllMovie();
        System.out.println("=============欢迎来到用户购票系统=============");
        System.out.println("请输入需要买票的门店");
        String shopName = SYS_SC.nextLine();
        //查看是否存在该商家
        Busicess busicess = getUserByShopName(shopName);
        if (busicess == null){
            System.out.println("对不起，没有此门店，请确认！");
        }else {
            List<Movie> movies = ALL_MOVIES.get(busicess);
            if (movies.size() > 0){
                while (true) {
                    System.out.println("请输入需要购买电影名称");
                    String movieName = SYS_SC.nextLine();
                    //去当前商家下，查询电影对象
                    Movie movie = getMovieByShopAndName(busicess,movieName);
                    if (movies.size() > 0){
                        System.out.println("请输入您要购买的电影票数");
                        String number = SYS_SC.nextLine();
                        int buyNumber = Integer.valueOf(number);
                        if (movie.getNumber() >= buyNumber){
                            //当前需要花费的金额
                            double money = BigDecimal.valueOf(movie.getPrice()).multiply(BigDecimal.valueOf(buyNumber)).doubleValue();
                            if (loginUser.getMoney() > money){
                                System.out.println("您成功购买了"+movie.getName()+buyNumber+"张票！总金额是："+money);
                                //更新自己的金额，更新商家的金额，更新剩余票数
                                loginUser.setMoney(loginUser.getMoney() - money);
                                busicess.setMoney(busicess.getMoney() + money);
                                movie.setNumber(movie.getNumber() - buyNumber);
                                return;
                            }else {
                                System.out.println("");
                            }
                        }
                        }else {
                            System.out.println("您当前最多可以购买："+movie.getNumber());
                            System.out.println("是否继续买票？y/n");
                            String commend = SYS_SC.nextLine();
                            switch (commend) {
                                case "y":
                                    break;
                                default:
                                    System.out.println("好的");
                                    return;

                        }
                    }
                }
            }else{
                System.out.println("该电影院关门了～～～");
                System.out.println("是否继续买票？y/n");
                String commend = SYS_SC.nextLine();
                switch (commend) {
                    case "y":
                        break;
                    default:
                        System.out.println("好的");
                        return;
                }
            }
        }

    }

    public static Busicess getUserByShopName(String shopName){
        Set<Busicess> busicesses = ALL_MOVIES.keySet();
        for (Busicess business : busicesses) {
            if(business.getShopName().equals(shopName)){
                return business;
            }
        }
        return null;
    }

    public static Movie getMovieByShopAndName(Busicess busicess,String name){
        List<Movie> movies = ALL_MOVIES.get(busicess);
        for (Movie movie : movies) {
            if (movie.getName().contains(name)){
                return movie;
            }
        }
        return null;
    }

    private static void showAllMovie() {
        System.out.println("===============展示商家全部排片信息===============");
        ALL_MOVIES.forEach((busicess, movies) -> {
        System.out.println(busicess.getShopName()+"\t\t电话:"+busicess.getPhone()+"\t\t地址："+busicess.getAddress());
        System.out.println("片名\t\t\t主演\t\t时长\t\t评分\t\t票价\t\t余票\t\t数量\t\t放映时间");

        for (Movie movie : movies) {
             System.out.println(movie.getName()+"\t\t\t"+movie.getActor()+"\t\t"+movie.getTime()
                            +"\t\t"+movie.getScore()+"\t\t"+movie.getPrice()+"\t\t"+movie.getNumber()+"\t\t"
                            +sdf.format(movie.getStartTime()));
                }
        });
    }

    //展示当前商家信息
    private static void showBusinessinfors() {
        System.out.println("================商家详情界面================");
        LOGGER.info(loginUser.getLoginName()+"正在看自己的详情～～～");
        //根据商家对象（就是登陆的用户loginUser），作为Map集合的键，提取对应的值就是排片信息
        Busicess busicess = (Busicess) loginUser;
        System.out.println(busicess.getShopName()+"\t\t电话:"+busicess.getPhone()+"\t\t地址："+busicess.getAddress());
        List<Movie> movies = ALL_MOVIES.get(loginUser);

        if (movies.size() > 0) {
            System.out.println("片名\t\t\t主演\t\t时长\t\t评分\t\t票价\t\t余票\t\t数量\t\t放映时间");
            for (Movie movie : movies) {
                System.out.println(movie.getName()+"\t\t\t"+movie.getActor()+"\t\t"+movie.getTime()
                    +"\t\t"+movie.getScore()+"\t\t"+movie.getPrice()+"\t\t"+movie.getNumber()+"\t\t"
                        +sdf.format(movie.getStartTime()));
            }
        }else {
            System.out.println("您的店铺当前没有上架电影！");
        }
    }

    public static User getUserByLoginName(String loginName) {
           for (User user : ALL_USERS) {
                if (user.getLoginName().equals(loginName)) {
                    return user;
                }
            }
        return null;
    }
}
