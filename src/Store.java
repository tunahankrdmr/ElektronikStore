import java.util.*;

public class Store {
    public static List<Brand> brands=new ArrayList<>();
    private Scanner sc=new Scanner(System.in);
    private boolean choose=true;
    public static HashMap<Integer, Notebook> notebookHashMap=new HashMap<>();
    public static HashMap<Integer, MobilePhone> mobilePhoneHashMap=new HashMap<>();

    static {
        brands.add(new Brand(1,"Samsung"));
        brands.add(new Brand(2,"Lenovo"));
        brands.add(new Brand(3,"Apple"));
        brands.add(new Brand(4,"Huawei"));
        brands.add(new Brand(5,"Casper"));
        brands.add(new Brand(6,"Asus"));
        brands.add(new Brand(7,"HP"));
        brands.add(new Brand(8,"Xiaomi"));
        brands.add(new Brand(9,"Monster"));
    }

    public Store() {
        brands.sort(Comparator.comparing(Brand::getName));
    }

    public void init(){
        while (this.choose){
            System.out.println("PatikaStore Ürün Yönetim Paneli");
            System.out.println("-------------------------------");
            System.out.println("1 - Notebook İşlemleri" +
                    "\n2 - Cep Telefonu İşlemleri" +
                    "\n3 - Marka Listele" +
                    "\n0 - Çıkış Yap");
            System.out.print("Tercihiniz : ");
            int secim=sc.nextInt();
            switch (secim){
                case 1 :
                    operationsNotebook();
                    break;
                case 2:
                    operationsMobilePhone();
                    break;
                case 3:
                    brandSort();
                    break;
                case 0 :
                    System.out.println("Sistemden çıkış yapılıyor!!!");
                    this.choose=false;
                    break;
                default:
                    init();
                    break;
            }
        }
    }

    public boolean brandSort(){
        for (Brand i : brands){
            System.out.println(" - " + i.getName());
        }
        return true;
    }

    public void operationsNotebook(){
        while (this.choose){
            System.out.println("1 - Ürün ekle" +
                    "\n2 - Ürün silme" +
                    "\n3 - Ürün listeleme" +
                    "\n4 - Markalarına göre listeleme" +
                    "\n0 - Çıkış yap");
            System.out.print("Tercihiniz : ");
            int secim=sc.nextInt();
            switch (secim){
                case 1:
                    addProductNotebook(notebookHashMap);
                    break;
                case 2 :
                    deleteProductNotebook(notebookHashMap);
                    break;
                case 3:
                    lisProductNotebook(notebookHashMap);
                    break;
                case 4:
                    filterBrandNotebookList(notebookHashMap);
                    break;
                case 0:
                    init();
                    break;
                default:
                    operationsNotebook();
                    break;
            }
        }
    }

    public void operationsMobilePhone(){
        while (this.choose){
            System.out.println("1 - Ürün ekle" +
                    "\n2 - Ürün silme" +
                    "\n3 - Ürün listeleme" +
                    "\n4 - Markalarına göre listeleme" +
                    "\n0 - Çıkış yap");
            System.out.print("Tercihiniz : ");
            int secim=sc.nextInt();
            switch (secim){
                case 1:
                    addProductMobilePhone(mobilePhoneHashMap);
                    break;
                case 2 :
                    deleteProductMobilePhone(mobilePhoneHashMap);
                    break;
                case 3:
                    lisProductMobilePhone(mobilePhoneHashMap);
                    break;
                case 4:
                    filterBrandMobileList(mobilePhoneHashMap);
                    break;
                case 0:
                    init();
                    break;
                default:
                    operationsNotebook();
                    break;
            }
        }
    }

    public boolean addProductNotebook(HashMap<Integer, Notebook> notebookHashMap){
        System.out.print("Ürün ismini giriniz : ");
        sc.nextLine();
        String name=sc.nextLine();
        System.out.print("Stok miktarını giriniz : ");
        int amountStoke=sc.nextInt();
        System.out.print("İndirim oranını giriniz : ");
        int discountRate=sc.nextInt();
        System.out.print("Ram değerini giriniz : ");
        int ram=sc.nextInt();
        System.out.print("Ekran boyutunu giriniz : ");
        int screenSize=sc.nextInt();
        System.out.print("Depolama değerini giriniz : ");
        int storage=sc.nextInt();
        System.out.print("Birim fiyatını giriniz : ");
        int unitPrice=sc.nextInt();
        boolean secim=true;
        Brand marka=null;
        while (secim){
            System.out.print("Markasını giriniz : ");
            String brand=sc.next();
            for (Brand i : brands){
                if (i.getName().equals(brand)){
                    marka=i;
                    secim=false;
                }
            }
            if (secim==true){
                System.out.println("Sistemde olmayan bir marka girdiniz!! Tekrar giriniz...");
            }
        }
        Product product=new Notebook(discountRate,amountStoke,name,marka,ram,screenSize,unitPrice,storage);
        notebookHashMap.put(product.getId(), (Notebook) product);
        return true;
    }

    public boolean addProductMobilePhone(HashMap<Integer, MobilePhone> mobilePhoneHashMap){
        System.out.print("Ürün ismini giriniz : ");
        sc.nextLine();
        String name=sc.nextLine();
        System.out.print("Stok miktarını giriniz : ");
        int amountStoke=sc.nextInt();
        System.out.print("İndirim oranını giriniz : ");
        int discountRate=sc.nextInt();
        System.out.print("Ram değerini giriniz : ");
        int ram=sc.nextInt();
        System.out.print("Ekran boyutunu giriniz : ");
        int screenSize=sc.nextInt();
        System.out.print("Hafıza bilgisini giriniz : ");
        int memory=sc.nextInt();
        System.out.print("Pil gücünü giriniz : ");
        int batteryPower=sc.nextInt();
        System.out.print("Rengini giriniz : ");
        sc.nextLine();
        String color=sc.nextLine();
        System.out.print("Birim fiyatını giriniz : ");
        int unitPrice=sc.nextInt();
        boolean secim=true;
        Brand marka=null;
        while (secim){
            System.out.print("Markasını giriniz : ");
            String brand=sc.next();
            for (Brand i : brands){
                if (i.getName().equals(brand)){
                    marka=i;
                    secim=false;
                }
            }
            if (secim==true){
                System.out.println("Sistemde olmayan bir marka girdiniz!! Tekrar giriniz...");
            }
        }
        Product product=new MobilePhone(discountRate,amountStoke,name,marka,ram,screenSize,unitPrice,memory,batteryPower,color);
        mobilePhoneHashMap.put(product.getId(), (MobilePhone) product);
        return true;
    }

    public boolean deleteProductNotebook(HashMap<Integer, Notebook> notebookHashMap){
        System.out.print("Silinecek ürünün ID değerini giriniz : ");
        int idNo=sc.nextInt();
        if (notebookHashMap.containsKey(idNo)){
            notebookHashMap.remove(idNo);
            System.out.println("Ürün silinmiştir.");
        }else {
            System.out.println("Girilen ID değerinde bir ürün yoktur!!!");
        }
        return true;
    }

    public boolean deleteProductMobilePhone(HashMap<Integer, MobilePhone> mobilePhoneHashMap){
        System.out.print("Silinecek ürünün ID değerini giriniz : ");
        int idNo=sc.nextInt();
        if (mobilePhoneHashMap.containsKey(idNo)){
            mobilePhoneHashMap.remove(idNo);
            System.out.println("Ürün silinmiştir.");
        }else {
            System.out.println("Girilen ID değerinde bir ürün yoktur!!!");
        }
        return true;
    }

    public boolean lisProductNotebook(HashMap<Integer, Notebook> notebookHashMap){
        String format = "| %-8s | %-30s | %-22s | %-12s | %-25s | %-16s | %-22s | %-16s | %-22s |\n";
        System.out.format("+----------+--------------------------------+------------------------+--------------+---------------------------+------------------+------------------------+------------------+------------------------+\n");
        System.out.format("| ID       | Ürün Adı                       | Marka                  | Ekran Boyutu | Depolama Kapasitesi       | RAM Kapasitesi   | Fiyat                  | Adet             | İndirim Oranı          |\n");
        System.out.format("+----------+--------------------------------+------------------------+--------------+---------------------------+------------------+------------------------+------------------+------------------------+\n");
        for (Notebook i : notebookHashMap.values()){
            System.out.format(format, i.getId(), i.getName(), i.getBrand().getName(), i.getScreenSize(), i.getStorage(), i.getRam(),  i.getUnitPrice(), i.getAmountStoke(), i.getDiscountRate());
            System.out.format("+----------+--------------------------------+------------------------+--------------+------------------------+------------------+------------------------+------------------+------------------------+\n");
        }
        return true;
    }

    public boolean lisProductMobilePhone(HashMap<Integer, MobilePhone> mobilePhoneHashMap){
        String format = "| %-8s | %-30s | %-22s | %-12s | %-25s | %-16s | %-22s | %-16s | %-22s | %-16s | %-12s |\n";
        System.out.format("+----------+--------------------------------+------------------------+--------------+---------------------------+------------------+------------------------+------------------+------------------------+------------------+--------------+\n");
        System.out.format("| ID       | Ürün Adı                       | Marka                  | Ekran Boyutu | Pil Gücü                  | RAM Kapasitesi   | Fiyat                  | Adet             | İndirim Oranı          | Renk             | Hafıza       |\n");
        System.out.format("+----------+--------------------------------+------------------------+--------------+---------------------------+------------------+------------------------+------------------+------------------------+------------------+--------------+\n");
        for (MobilePhone i : mobilePhoneHashMap.values()){
            System.out.format(format, i.getId(), i.getName(), i.getBrand().getName(), i.getScreenSize(), i.getBatteryPower(), i.getRam(),  i.getUnitPrice(), i.getAmountStoke(), i.getDiscountRate(), i.getColor(), i.getMemory());
            System.out.format("+----------+--------------------------------+------------------------+--------------+------------------------+------------------+------------------------+------------------+------------------------+------------------+--------------+\n");
        }
        return true;
    }

    public boolean filterBrandNotebookList(HashMap<Integer, Notebook> notebookHashMap){
        String format = "| %-8s | %-30s | %-22s | %-12s | %-25s | %-16s | %-22s | %-16s | %-22s |\n";
        System.out.format("+----------+--------------------------------+------------------------+--------------+---------------------------+------------------+------------------------+------------------+------------------------+\n");
        System.out.format("| ID       | Ürün Adı                       | Marka                  | Ekran Boyutu | Depolama Kapasitesi       | RAM Kapasitesi   | Fiyat                  | Adet             | İndirim Oranı          |\n");
        System.out.format("+----------+--------------------------------+------------------------+--------------+---------------------------+------------------+------------------------+------------------+------------------------+\n");
        TreeMap<String, Notebook> notebookTreeMap=new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        for (Notebook i : notebookHashMap.values()){
            notebookTreeMap.put(i.getBrand().getName(),i);
        }
        for (Notebook j : notebookTreeMap.values()){
            System.out.format(format, j.getId(), j.getName(), j.getBrand().getName(), j.getScreenSize(), j.getStorage(), j.getRam(),  j.getUnitPrice(), j.getAmountStoke(), j.getDiscountRate());
            System.out.format("+----------+--------------------------------+------------------------+--------------+------------------------+------------------+------------------------+------------------+------------------------+\n");
        }
        return true;
    }

    public boolean filterBrandMobileList(HashMap<Integer, MobilePhone> mobilePhoneHashMap){
        String format = "| %-8s | %-30s | %-22s | %-12s | %-25s | %-16s | %-22s | %-16s | %-22s | %-16s | %-12s |\n";
        System.out.format("+----------+--------------------------------+------------------------+--------------+---------------------------+------------------+------------------------+------------------+------------------------+------------------+--------------+\n");
        System.out.format("| ID       | Ürün Adı                       | Marka                  | Ekran Boyutu | Pil Gücü                  | RAM Kapasitesi   | Fiyat                  | Adet             | İndirim Oranı          | Renk             | Hafıza       |\n");
        System.out.format("+----------+--------------------------------+------------------------+--------------+---------------------------+------------------+------------------------+------------------+------------------------+------------------+--------------+\n");
        TreeMap<String, MobilePhone> mobilePhoneTreeMap=new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        for (MobilePhone i : mobilePhoneHashMap.values()){
            mobilePhoneTreeMap.put(i.getBrand().getName(),i);
        }
        for (MobilePhone j : mobilePhoneTreeMap.values()){
            System.out.format(format, j.getId(), j.getName(), j.getBrand().getName(), j.getScreenSize(), j.getBatteryPower(), j.getRam(),  j.getUnitPrice(), j.getAmountStoke(), j.getDiscountRate(), j.getColor(), j.getMemory());
            System.out.format("+----------+--------------------------------+------------------------+--------------+------------------------+------------------+------------------------+------------------+------------------------+------------------+--------------+\n");
        }
        return true;
    }
}
