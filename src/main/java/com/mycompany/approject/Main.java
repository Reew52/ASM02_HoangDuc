/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.approject;

/**
 *
 * @author hduc2
 */
import com.mycompany.approject.Operations.Operations;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        MainMenu();
    }

    public static void MainMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("-------------------------------------Main Menu-------------------------------------");
            System.out.println("Select an option:");
            System.out.println("1. Manage Brands");
            System.out.println("2. Manage Hardware");
            System.out.println("3. Manage PCs");
            System.out.println("0. Exit");
            System.out.println("-----------------------------------------------------------------------------------------");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    BrandMenu();
                    break;
                case 2:
                    HardwareMenu();
                    break;
                case 3:
                    PCMenu();
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }

        } while (option != 0);
    }

    public static void BrandMenu() {
        ArrayList<Brand> elements = new ArrayList<>();
        Operations<Brand> brand = new Operations<>(elements);
        elements = brandList(elements);
        Scanner scanner = new Scanner(System.in);
        int brandOption;
        do {
            System.out.println("-------------------------------------Brand Menu-------------------------------------");
            System.out.println("Select a Brand operation:");
            System.out.println("1. Add Brand");
            System.out.println("2. Delete Brand");
            System.out.println("3. Find Brand by Code");
            System.out.println("4. Display all Brands");
            System.out.println("5. Update brand");
            System.out.println("6. Preview");
            System.out.println("------------------------------------------------------------------------------------------");

            brandOption = scanner.nextInt();

            switch (brandOption) {
                case 1:
                     try {
                    System.out.println("Set Code:");
                    String code = scanner.next();
                    System.out.println("Set Name:");
                    String name = scanner.next();
                    Brand AddBrand = new Brand();
                    AddBrand.setCode(code);
                    AddBrand.setName(name);
                    brand.add(AddBrand);
                    System.out.println("Add the brand, successfully");

                } catch (Exception e) {
                    System.out.println("Error:" + e.getMessage());
                }
                break;
                case 2:
                    try {
                    System.out.println("Delete Code:");
                    String Code = scanner.next();
                    Brand FindBrand = brand.findByCodeOrName(Code);
                    if (FindBrand == null) {
                        System.out.println("Not exist the brand");
                    } else {
                        brand.delete(FindBrand);
                        System.out.println("Remove the brand, successfully");

                    }
                } catch (Exception e) {
                    System.out.println("Error:" + e.getMessage());
                }
                break;
                case 3:
                    try {
                    System.out.println("find Hardware by Code or name:");
                    String CodeOrName = scanner.next();
                    Brand FindBrand = brand.findByCodeOrName(CodeOrName);
                    if (FindBrand == null) {
                        System.out.println("Not exist the hardware");
                    } else {
                        String leftAlignFormat = "| %-4d | %-14s | %-41s | %-32s | %-34s |%n";
                        System.out.format("+------+----------------+--------------------------------------------+------------------------------------+----------------------------------+%n");
                        System.out.format("| ID   | Code           | Name                                       | Created At                         | Updated At                       |%n");
                        System.out.format("+------+----------------+--------------------------------------------+------------------------------------+----------------------------------+%n");
                        System.out.format(leftAlignFormat, FindBrand.getId(), FindBrand.getCode(), FindBrand.getName(), FindBrand.getCreated(), FindBrand.getUpdated());
                        System.out.format("+------+----------------+--------------------------------------------+------------------------------------+----------------------------------+%n");
                    }
                } catch (Exception e) {
                    System.out.println("Error:" + e.getMessage());
                }
                break;
                case 4:
                    ArrayList<Brand> brands = brand.getAll(elements);
                    String leftAlignFormat = "| %-4d | %-14s | %-42s | %-32s | %-34s |%n";
                    System.out.format("+------+----------------+--------------------------------------------+------------------------------------+----------------------------------+%n");
                    System.out.format("| ID   | Code           | Name                                       | Created At                         | Updated At                       |%n");
                    System.out.format("+------+----------------+--------------------------------------------+------------------------------------+----------------------------------+%n");
                    for (Brand items : brands) {
                        System.out.format(leftAlignFormat, items.getId(), items.getCode(), items.getName(), items.getCreated(), items.getUpdated());
                    }
                    System.out.format("+------+----------------+--------------------------------------------+------------------------------------+----------------------------------+%n");
                    break;
                case 5:
                    System.out.println("find Hardware by Code or name:");
                    String CodeOrName = scanner.next();
                    Brand FindBrand = brand.findByCodeOrName(CodeOrName);
                    if (FindBrand == null) {
                        System.out.println("Not exist the hardware");
                    } else {
                        System.out.println("Set Code:");
                        String code = scanner.next();
                        System.out.println("Set Name:");
                        String name = scanner.next();
                        FindBrand.setCode(code);
                        FindBrand.setName(name);
                        FindBrand.setUpdated(LocalDateTime.now());
                    }
                    break;
                case 6:
                    MainMenu();
                    break;
                default:
                    System.out.println("Invalid option for Brand");
                    break;
            }
        } while (brandOption != 0);
    }

    public static void HardwareMenu() {
        ArrayList<Hardware> elements = new ArrayList<>();
        Operations<Hardware> hardware = new Operations<>(elements);
        elements = hardwareList(elements);
        Scanner scanner = new Scanner(System.in);
        int hardwareOption;
        do {
            System.out.println("-------------------------------------Hardware Menu-------------------------------------");
            System.out.println("Select a Hardware operation:");
            System.out.println("1. Add Hardware");
            System.out.println("2. Delete Hardware");
            System.out.println("3. Find Hardware by Code");
            System.out.println("4. Display all Hardware");
            System.out.println("5. Update Hardware");
            System.out.println("6. Preview");
            System.out.println("-----------------------------------------------------------------------------------------------");
            hardwareOption = scanner.nextInt();

            switch (hardwareOption) {
                case 1:
                    try {
                    System.out.println("Set Code:");
                    String code = scanner.next();
                    System.out.println("Set Type:");
                    String type = scanner.next();
                    System.out.println("Set Name:");
                    String name = scanner.next();
                    System.out.println("Set Capacity:");
                    String capacity = scanner.next();
                    System.out.println("Set Price:");
                    int Price = scanner.nextInt();
                    String price = Integer.toString(Price);

                    Hardware AddHardware = new Hardware();
                    AddHardware.setCode(code);
                    AddHardware.setCapacity(capacity);
                    AddHardware.setPrice(price);
                    AddHardware.setName(name);
                    AddHardware.setType(type);
                    hardware.add(AddHardware);
                    System.out.println("Add the hardware, successfully");

                } catch (Exception e) {
                    System.out.println("Error:" + e.getMessage());
                }

                break;
                case 2:
                    try {
                    System.out.println("Delete Code:");
                    String Code = scanner.next();
                    Hardware FindHardware = hardware.findByCodeOrName(Code);
                    if (FindHardware == null) {
                        System.out.println("Not exist the hardware");
                    } else {
                        hardware.delete(FindHardware);
                        System.out.println("Remove the hardware, successfully");

                    }
                } catch (Exception e) {
                    System.out.println("Error:" + e.getMessage());
                }
                break;
                case 3:
                    try {
                    System.out.println("find Hardware by Code or name:");
                    String CodeOrName = scanner.next();
                    Hardware FindHardware = hardware.findByCodeOrName(CodeOrName);
                    if (FindHardware == null) {
                        System.out.println("Not exist the hardware");
                    } else {
                        String leftAlignFormat = "| %-4d | %-14s | %-42s | %-22s | %-22s | %-24s | %-17s | %-32s | %-34s |%n";
                        System.out.format("+------+----------------+--------------------------------------------+-----------------------+-----------------------+------------------------+-------------------+------------------------------------+----------------------------------+%n");
                        System.out.format("| ID   | Code           | Name                                       |Brand                  |Type                   |Capacity                | Price             | Created At                         | Updated At                       |%n");
                        System.out.format("+------+----------------+--------------------------------------------+-----------------------+-----------------------+------------------------+-------------------+------------------------------------+----------------------------------+%n");
                        System.out.format(leftAlignFormat, FindHardware.getId(), FindHardware.getCode(), FindHardware.getName(), FindHardware.getBrand(), FindHardware.getType(), FindHardware.getCapacity(), FindHardware.getPrice(), FindHardware.getCreated(), FindHardware.getUpdated());
                        System.out.format("+------+----------------+--------------------------------------------+-----------------------+-----------------------+------------------------+-------------------+------------------------------------+----------------------------------+%n");
                    }
                } catch (Exception e) {
                    System.out.println("Error:" + e.getMessage());
                }
                break;
                case 4:
                    ArrayList<Hardware> hardwares = hardware.getAll(elements);
                    String leftAlignFormat = "| %-4d | %-14s | %-42s | %-23s| %-23s | %-30s | %-17s | %-32s | %-32s |%n";
                    System.out.format("+------+----------------+--------------------------------------------+------------------------+-------------------------+--------------------------------+-------------------+----------------------------------+----------------------------------+%n");
                    System.out.format("| ID   | Code           | Name                                       |Brand                    |Type                     |Capacity                        | Price             | Created At                       | Updated At                       |%n");
                    System.out.format("+------+----------------+--------------------------------------------+------------------------+-------------------------+--------------------------------+-------------------+----------------------------------+----------------------------------+%n");
                    for (Hardware items : hardwares) {
                        System.out.format(leftAlignFormat, items.getId(), items.getCode(), items.getName(), items.getBrand(), items.getType(), items.getCapacity(), items.getPrice(), items.getCreated(), items.getUpdated());
                    }
                    System.out.format("+------+----------------+--------------------------------------------+------------------------+-------------------------+--------------------------------+-------------------+----------------------------------+----------------------------------+%n");
                    break;
                case 5:
                    System.out.println("find Hardware by Code or name:");
                    String CodeOrName = scanner.next();
                    Hardware FindHardware = hardware.findByCodeOrName(CodeOrName);
                    if (FindHardware == null) {
                        System.out.println("Not exist the hardware");
                    } else {
                        System.out.println("Set Code:");
                        String code = scanner.next();
                        System.out.println("Set Type:");
                        String type = scanner.next();
                        System.out.println("Set Brand:");
                        String brand = scanner.next();
                        System.out.println("Set Name:");
                        String name = scanner.next();
                        System.out.println("Set Capacity:");
                        String capacity = scanner.next();
                        System.out.println("Set Price:");
                        int Price = scanner.nextInt();
                        String price = Integer.toString(Price);
                        FindHardware.setBrand(brand);
                        FindHardware.setCode(code);
                        FindHardware.setCapacity(capacity);
                        FindHardware.setPrice(price);
                        FindHardware.setName(name);
                        FindHardware.setType(type);
                        FindHardware.setUpdated(LocalDateTime.now());
                    }
                    break;
                case 6:
                    MainMenu();
                    break;
                default:
                    System.out.println("Invalid option for Hardware");
                    break;
            }
        } while (hardwareOption != 0);
    }

    public static void PCMenu() {
        ArrayList<PC> elements = new ArrayList<>();
        Operations<PC> pc = new Operations<>(elements);
        elements = PCList(elements);
        Scanner scanner = new Scanner(System.in);
        int pcOption;
        do {
            System.out.println("-------------------------------------PC Menu-------------------------------------");
            System.out.println("Select a PC operation:");
            System.out.println("1. Add PC");
            System.out.println("2. Delete PC");
            System.out.println("3. Find PC by Code");
            System.out.println("4. Display all PCs");
            System.out.println("5. Update PC");
            System.out.println("6. Preview");
            System.out.println("--------------------------------------------------------------------------------------");

            pcOption = scanner.nextInt();

            switch (pcOption) {
                case 1:
                    try {
                    System.out.println("Set Code:");
                    String code = scanner.next();
                    System.out.println("Set Name:");
                    String name = scanner.next();
                    System.out.println("Set Brand:");
                    String brand = scanner.next();
                    System.out.println("Set Price:");
                    int Price = scanner.nextInt();
                    String price = Integer.toString(Price);
                    System.out.println("Set the number of hardware:");
                    int num = scanner.nextInt();
                    System.out.println("Set the hardwares:");
                    ArrayList<String> hardwares = new ArrayList<>();
                    for (int i = 0; i < num - 1; i++) {
                        String hardware = scanner.next();
                        hardwares.add(hardware);
                    }
                    PC AddPC = new PC();
                    AddPC.setCode(code);
                    AddPC.setBrand(brand);
                    AddPC.setPrice(price);
                    AddPC.setName(name);
                    for (String item : hardwares) {
                        AddPC.setHardwareList(item);
                    }
                    pc.add(AddPC);
                    System.out.println("Add the PC, successfully");

                } catch (Exception e) {
                    System.out.println("Error:" + e.getMessage());
                }
                break;
                case 2:
                    System.out.println("Find PC:");
                    String CodeOrName = scanner.next();
                    PC findPC = pc.findByCodeOrName(CodeOrName);
                    if (findPC != null) {
                        pc.delete(findPC);
                        System.out.println("Delete PC successfully");
                    } else {
                        System.out.println("Not exist PC");
                    }
                    break;
                case 3:
                    System.out.println("Find PC:");
                    String codeOrName = scanner.next();
                    PC FindPC = pc.findByCodeOrName(codeOrName);
                    if (FindPC != null) {
                        System.out.format("| %-4s | %-14s | %-42s | %-23s | %-17s | %-32s | %-32s | %-50s%n", "ID", "Code", "Name", "Brand", "Price", "Created", "Updated", "Hardware");
                        System.out.format("+------+----------------+--------------------------------------------+------------------------+-------------------+----------------------------------+----------------------------------+----------------------------------------------------+%n");

                        System.out.format("| %-4d | %-14s | %-42s | %-23s | %-17s | %-32s | %-32s | ", FindPC.getId(), FindPC.getCode(), FindPC.getName(), FindPC.getBrand(), FindPC.getPrice(), FindPC.getCreated(), FindPC.getUpdated());
                        for (String hardware : FindPC.getHardwareList()) {
                            System.out.format("%-48s | ", hardware);
                        }
                        System.out.println();

                        System.out.format("+------+----------------+--------------------------------------------+------------------------+-------------------+----------------------------------+----------------------------------+----------------------------------------------------+%n");
                    } else {
                        System.out.println("Not exist PC");
                    }
                    break;
                case 4:
                    ArrayList<PC> pcs = pc.getAll(elements);
                    System.out.format("| %-4s | %-14s | %-42s | %-23s | %-17s | %-32s | %-32s | %-50s%n", "ID", "Code", "Name", "Brand", "Price", "Created", "Updated", "Hardware");
                    System.out.format("+------+----------------+--------------------------------------------+------------------------+-------------------+----------------------------------+----------------------------------+----------------------------------------------------+%n");
                    for (PC items : pcs) {
                        System.out.format("| %-4d | %-14s | %-42s | %-23s | %-17s | %-32s | %-32s | ", items.getId(), items.getCode(), items.getName(), items.getBrand(), items.getPrice(), items.getCreated(), items.getUpdated());
                        for (String hardware : items.getHardwareList()) {
                            System.out.format("%-48s | ", hardware);
                        }
                        System.out.println();
                    }
                    System.out.format("+------+----------------+--------------------------------------------+------------------------+-------------------+----------------------------------+----------------------------------+----------------------------------------------------+%n");

                    break;
                case 5:
                    System.out.println("Find PC:");
                    String CodeorName = scanner.next();
                    PC FIndPC = pc.findByCodeOrName(CodeorName);
                    if (FIndPC != null) {
                        System.out.println("Set Code:");
                        String code = scanner.next();
                        System.out.println("Set Name:");
                        String name = scanner.next();
                        System.out.println("Set Brand:");
                        String brand = scanner.next();
                        System.out.println("Set Price:");
                        int Price = scanner.nextInt();
                        String price = Integer.toString(Price);
                        System.out.println("Set the number of hardware:");
                        int num = scanner.nextInt();
                        System.out.println("Set the hardwares:");
                        ArrayList<String> hardwares = new ArrayList<>();
                        for (int i = 0; i < num - 1; i++) {
                            String hardware = scanner.next();
                            hardwares.add(hardware);
                        }
                        FIndPC.setCode(code);
                        FIndPC.setBrand(brand);
                        FIndPC.setPrice(price);
                        FIndPC.setName(name);
                        for (String item : hardwares) {
                            FIndPC.setHardwareList(item);
                        }
                        FIndPC.setUpdated(LocalDateTime.now());
                        System.out.println("Update PC successfully");
                    } else {
                        System.out.println("Not exist PC");
                    }
                    break;
                case 6:
                    MainMenu();
                    break;
                default:
                    System.out.println("Invalid option for PC");
                    break;
            }
        } while (pcOption != 0);

    }

    public static ArrayList<Brand> brandList(ArrayList<Brand> elements) {
        Brand brand1 = new Brand();
        brand1.setCode("B001");
        brand1.setName("Intel");

        Brand brand2 = new Brand();
        brand2.setCode("B002");
        brand2.setName("AMD");

        Brand brand3 = new Brand();
        brand3.setCode("B003");
        brand3.setName("Nvidia");

        Brand brand4 = new Brand();
        brand4.setCode("B004");
        brand4.setName("ASUS");

        Brand brand5 = new Brand();
        brand5.setCode("B005");
        brand5.setName("Gigabyte");

        Brand brand6 = new Brand();
        brand6.setCode("B006");
        brand6.setName("MSI");

        Brand brand7 = new Brand();
        brand7.setCode("B007");
        brand7.setName("Corsair");

        Brand brand8 = new Brand();
        brand8.setCode("B008");
        brand8.setName("Western Digital");

        elements.add(brand1);
        elements.add(brand2);
        elements.add(brand3);
        elements.add(brand4);
        elements.add(brand5);
        elements.add(brand6);
        elements.add(brand7);
        elements.add(brand8);
        return elements;
    }

    public static ArrayList<Hardware> hardwareList(ArrayList<Hardware> elements) {
        Hardware hardware1 = new Hardware();
        hardware1.setCode("H001");
        hardware1.setName("Intel Core i9-11900K Processor");
        hardware1.setType("Processor");
        hardware1.setBrand("Intel");
        hardware1.setCapacity("8 Cores, 16 Threads");
        hardware1.setPrice("$539");
        elements.add(hardware1);

        Hardware hardware2 = new Hardware();
        hardware2.setCode("H002");
        hardware2.setName("NVIDIA GeForce RTX 3070 Graphics Card");
        hardware2.setType("Graphics Card");
        hardware2.setBrand("NVIDIA");
        hardware2.setCapacity("8GB GDDR6");
        hardware2.setPrice("$499");
        elements.add(hardware2);

        Hardware hardware3 = new Hardware();
        hardware3.setCode("H003");
        hardware3.setName("Samsung 980 Pro SSD");
        hardware3.setType("Solid State Drive");
        hardware3.setBrand("SamSung");
        hardware3.setCapacity("1TB");
        hardware3.setPrice("$229");
        elements.add(hardware3);

        Hardware hardware4 = new Hardware();
        hardware4.setCode("H004");
        hardware4.setName("G.Skill Trident Z Neo 64GB DDR4 RAM");
        hardware4.setType("RAM");
        hardware4.setBrand("G.Skill");
        hardware4.setCapacity("64GB (4 x 16GB)");
        hardware4.setPrice("$389");
        elements.add(hardware4);

        Hardware hardware5 = new Hardware();
        hardware5.setCode("H005");
        hardware5.setName("ASUS TUF Gaming B550-PLUS Motherboard");
        hardware5.setType("Motherboard");
        hardware5.setBrand("Asus");
        hardware5.setCapacity("ATX");
        hardware5.setPrice("$159");
        elements.add(hardware5);

        Hardware hardware6 = new Hardware();
        hardware6.setCode("H006");
        hardware6.setName("Seagate IronWolf 8TB Hard Drive");
        hardware6.setType("Hard Drive");
        hardware6.setBrand("Seagate");
        hardware6.setCapacity("8TB");
        hardware6.setPrice("$249");
        elements.add(hardware6);

        Hardware hardware7 = new Hardware();
        hardware7.setCode("H007");
        hardware7.setName("Noctua NH-D15 CPU Cooler");
        hardware7.setType("CPU Cooler");
        hardware7.setBrand("Noctua");
        hardware7.setCapacity("Dual 140mm Fans");
        hardware7.setPrice("$89");
        elements.add(hardware7);

        Hardware hardware8 = new Hardware();
        hardware8.setCode("H008");
        hardware8.setName("Fractal Design Meshify C Case");
        hardware8.setType("Computer Case");
        hardware8.setBrand("Fractal");
        hardware8.setCapacity("ATX");
        hardware8.setPrice("$99");
        elements.add(hardware8);

        Hardware hardware9 = new Hardware();
        hardware9.setCode("H009");
        hardware9.setName("Razer DeathAdder Elite Gaming Mouse");
        hardware9.setType("Gaming Mouse");
        hardware9.setBrand("Razer");
        hardware9.setCapacity("16000 DPI");
        hardware9.setPrice("$69");
        elements.add(hardware9);

        Hardware hardware10 = new Hardware();
        hardware10.setCode("H010");
        hardware10.setName("Corsair K100 RGB Gaming Keyboard");
        hardware10.setType("Gaming Keyboard");
        hardware10.setBrand("Corsair");
        hardware10.setCapacity("Opto-Mechanical Switches");
        hardware10.setPrice("$229");
        elements.add(hardware10);

        Hardware hardware11 = new Hardware();
        hardware11.setCode("H011");
        hardware11.setName("LG 27GN950-B 4K Gaming Monitor");
        hardware11.setType("Gaming Monitor");
        hardware11.setBrand("LG");
        hardware11.setCapacity("27-inch, 4K resolution");
        hardware11.setPrice("$1199");
        elements.add(hardware11);

        Hardware hardware12 = new Hardware();
        hardware12.setCode("H012");
        hardware12.setName("Apple AirPods Pro");
        hardware12.setType("Earbuds");
        hardware12.setBrand("Apple");
        hardware12.setCapacity("Active noise cancellation");
        hardware12.setPrice("$249");
        elements.add(hardware12);
        return elements;
    }

    public static ArrayList<PC> PCList(ArrayList<PC> elements) {
        PC pc1 = new PC();
        pc1.setCode("PC001");
        pc1.setName("Gaming PC");
        pc1.setBrand("ASUS");
        pc1.setPrice("$1500");
        pc1.setHardwareList("Western Digital Hard Drive");
        pc1.setHardwareList("Samsung SSD");
        pc1.setHardwareList("Nvidia GeForce RTX 3080");

        PC pc2 = new PC();
        pc2.setCode("PC002");
        pc2.setName("Office PC");
        pc2.setBrand("Intel");
        pc2.setPrice("$800");
        pc2.setHardwareList("Intel Core i5-11600K Processor");
        pc2.setHardwareList("ASUS Prime Z590-P Motherboard");
        pc2.setHardwareList("Corsair Vengeance LPX 16GB DDR4 RAM");

        PC pc3 = new PC();
        pc3.setCode("PC003");
        pc3.setName("Custom PC");
        pc3.setBrand("Corsair");
        pc3.setPrice("$1200");
        pc3.setHardwareList("Corsair RM750 Power Supply");
        pc3.setHardwareList("NZXT H510 Elite Case");
        pc3.setHardwareList("Corsair H100i RGB Platinum SE Liquid CPU Cooler");

        PC pc4 = new PC();
        pc4.setCode("PC004");
        pc4.setName("Home PC");
        pc4.setBrand("LG");
        pc4.setPrice("$1000");
        pc4.setHardwareList("LG 27GL83A-B 27 Inch Ultragear QHD IPS Gaming Monitor");
        pc4.setHardwareList("Logitech MK270 Wireless Keyboard and Mouse Combo");

        PC pc5 = new PC();
        pc5.setCode("PC005");
        pc5.setName("Media PC");
        pc5.setBrand("Creative");
        pc5.setPrice("$900");
        pc5.setHardwareList("Creative Sound Blaster Audigy FX PCIe 5.1 Sound Card");
        pc5.setHardwareList("Logitech Z623 2.1 Speaker System");

        elements.add(pc1);
        elements.add(pc2);
        elements.add(pc3);
        elements.add(pc4);
        elements.add(pc5);
        return elements;
    }
}
