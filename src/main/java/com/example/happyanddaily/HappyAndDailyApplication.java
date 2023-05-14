package com.example.happyanddaily;

import com.example.happyanddaily.domain.menu.entity.Menu;
import com.example.happyanddaily.domain.menu.repository.MenuRepository;
import com.example.happyanddaily.domain.shop.repository.ShopRepository;
import com.example.happyanddaily.domain.shop.entity.Shop;
import com.example.happyanddaily.domain.systemmenu.entity.SystemMenu;
import com.example.happyanddaily.domain.systemmenu.repository.SystemMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class HappyAndDailyApplication {

    public static void main(String[] args) {

        SpringApplication.run(HappyAndDailyApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(ShopRepository shopRepository, MenuRepository menuRepository, SystemMenuRepository systemMenuRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {

                this.createShop();
                this.createMenu();
                this.createSystemMenu();
            }

            private void createSystemMenu() {
                List<SystemMenu> list = new ArrayList<>();

                // 1Depth(0 ~ 4)
                for(int i=0; i<5; i++){
                    SystemMenu depth1Menu = new SystemMenu();
                    if(i==2) continue;
                    depth1Menu.setDepth1(String.format("%02d", i));
                    list.add(depth1Menu);
                }

                // 2Depth (주문메뉴)
                for(int i=0; i<10; i++){
                    SystemMenu depth2Menu = new SystemMenu();
                    depth2Menu.setDepth1("02");
                    depth2Menu.setDepth2(String.format("%02d", i));
                    list.add(depth2Menu);
                }

                list.forEach(item ->{
                    switch (item.getDepth1()){
                        case "00": item.setSystemMenuName("홈"); item.setUrl("/"); break;
                        case "01": item.setSystemMenuName("소개"); item.setUrl("/about"); break;
                        case "02":
                            switch (item.getDepth2()) {
                                case "00": item.setSystemMenuName("대표메뉴"); item.setUrl("/menu/01"); break;
                                case "01": item.setSystemMenuName("컵과일, 과일 도시락"); item.setUrl("/menu/02"); break;
                                case "02": item.setSystemMenuName("과일 단품"); item.setUrl("/menu/03"); break;
                                case "03": item.setSystemMenuName("와플"); item.setUrl("/menu/04"); break;
                                case "04": item.setSystemMenuName("일만 드시기 심심하시죠"); item.setUrl("/menu/05"); break;
                                case "05": item.setSystemMenuName("행복과일상 Cafe (커피 & 차)"); item.setUrl("/menu/06"); break;
                                case "06": item.setSystemMenuName("생 과일 주스"); item.setUrl("/menu/07"); break;
                                case "07": item.setSystemMenuName("떡볶이"); item.setUrl("/menu/08"); break;
                                case "08": item.setSystemMenuName("대용량 1L 음료"); item.setUrl("/menu/09"); break;
                                case "09": item.setSystemMenuName("요거트 아이스크림"); item.setUrl("/menu/10"); break;
                            };
                            break;
                        case "03": item.setDepth1("80"); item.setSystemMenuName("장바구니");item.setUrl("/cart"); break;
                        case "04": item.setDepth1("90"); item.setSystemMenuName("로그인");item.setUrl("/login"); break;
                        default: item.setUrl("/"); break;
                    };
                });

                systemMenuRepository.saveAll(list);
            }

            private void createMenu() {

                List<Menu> list = new ArrayList<>();

                Menu menu1 = new Menu();
                menu1.setMenuName("컵과일, 과일컵 이 일대에서는 이집이 최고 입니다.(12온즈)");
                menu1.setMenuPrice(new BigDecimal(4900));
                menu1.setCategoryMain("대표메뉴");
                menu1.setCategorySub("");
                menu1.setMenuDescription("아래 준비된 과일 중 6~7가지 정도로 배달됩니다. 컵과일은 시간이 많이 소요 됩니다. 품절로 되어 있거나 가게가 임시중지라도 컵과일 주문은 가게로 연락 부탁 드립니다. 010칠육일오7953 1.사과 2.단감 3.배 4.스테비아방울토마토or방울토마토 5.크림슨적포도or청포도 6.오렌지 7.그린키위 8.골드키위 9.감귤 10.파인애플 11.만감류(한라봉,레드향,천혜향,황금향) 12.딸기 13.용과 14.바나나 15.블루베리");
                menu1.setImgPath("/images/menu/01/01_cup_fruit.jpeg");
                menu1.setStars(2);
                menu1.setSaleYn(true);
                list.add(menu1);

                Menu menu2 = new Menu();
                menu2.setMenuName("피부를 그대에게 애플망고(한개)");
                menu2.setMenuPrice(new BigDecimal(15000));
                menu2.setCategoryMain("대표메뉴");
                menu2.setCategorySub("");
                menu2.setMenuDescription("다른 가게와 가격 비교해보세요. 이번에 구매한 애플망고는 상당히 괜찮습니다. 피부미용과 눈 건강에 도움이 된다고 합니다. 약 450~500g 정도 되는 페루산 애플망고 입니다. 비교적 큰 편입니다.10% 미만의 에어포켓은 그대로 배달 됩니다. 생과일 그대로 구매하는 것도 고려해 보세요.");
                menu2.setImgPath("/images/menu/01/02_apple_mango.jpeg");
                menu2.setStars(4);
                menu2.setSaleYn(false);
                list.add(menu2);

                Menu menu3 = new Menu();
                menu3.setMenuName("향도 맛도 좋은 딸기(죽향250g이상(소))");
                menu3.setMenuPrice(new BigDecimal(11000));
                menu3.setCategoryMain("대표메뉴");
                menu3.setCategorySub("");
                menu3.setMenuDescription("딸기가 끝물이라서 괜찮은 딸기를 하도 구하기 어려워 거의 최고가인 죽향 딸기만 매입해 왔습니다. 같은 딸기라도 품종에 따라 시장 가면 가격 차이가 꽤 있습니다. 참고해주세요.");
                menu3.setImgPath("/images/menu/01/03_strawberry.jpeg");
                menu3.setStars(5);
                menu3.setSaleYn(true);
                list.add(menu3);

                menuRepository.saveAll(list);

            }

            public void createShop(){
                Shop shop = new Shop();
                shop.setShopCategory("fruits");
                shop.setShopName("행복과일상");
                shop.setShopTel("0507-1395-7953");
                shop.setShopAddress("서울 중구 서소문로9길 28 101동 L층 108호(순화동, 덕수궁롯데캐슬)");
                shop.setShopThumbPath("/images/shop/shop.jpeg");
                shop.setShopDescription("행복과일상이라는 상호명은 '행복과 일상' '행복 과일상' 이라는 2가지 의미와 마지막에 '상'은 상차림이라는 표현을 할때의 '상'의 의미를 가지고 왔습니다. 생과일, 생과일 주스 등 과일로 하는 식음료 판매 및 벤앤제리스 아이스크림 취급점 입니다. 과일은 가락도매시장 및 강서도매시장에서 제철에 맞는 과일을 구입하고 있으며, 다른 여러 종류의 과일을 구입하여 판매 할 수 있지만 손님의 별도 요청사항이 있지 않는 한 제철에 맞지 않는 과일은 판매를 지양하려고 합니다. 또 신선도의 문제등으로 가능하면 한번 구입할 때 무리해서 구입하지 않고 필요한 것들만 구입하여 손님들께 최대한 신선한 과일을 제공하고자 노력하고 있습니다. 이 구역에서는 과일 및 아이스크림은 행복과일상이 최고 입니다!!");

                shopRepository.save(shop);
            }

        };
    }
}
