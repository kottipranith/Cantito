package com.cantito.CantitoBackend;

import com.cantito.CantitoBackend.entities.Canteen;
import com.cantito.CantitoBackend.entities.Item;
import com.cantito.CantitoBackend.entities.User;
import com.cantito.CantitoBackend.service.CanteenService;
import com.cantito.CantitoBackend.service.ItemService;
import com.cantito.CantitoBackend.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class CantitoBackendApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CantitoBackendApplication.class, args);
		CanteenService canteenService = context.getBean(CanteenService.class);
//		Canteen canteen = new Canteen();
//		canteen.setCanteenName("sri amma mess");
//		canteen.setLocation("c block 2nd floor beside washrooms");
//		canteen.setOwnerId("pranith03");
//		canteenService.save(canteen);

		ItemService itemService = context.getBean(ItemService.class);
//		Item item = new Item();
//		item.setPrice(100);
//		item.setAvaliable(true);
//		item.setItemName("meals");
//		itemService.save(1, item);
		System.out.println(itemService.findById(1, 2));
		System.out.println(itemService.findByCanteenId(1));
		itemService.makeItemUnavailable(1, 2);
		System.out.println(itemService.findById(1, 2));
		itemService.makeItemAvailable(1, 2);
		System.out.println(itemService.findById(1, 2));
		itemService.updatePrice(1,2,110);
		System.out.println(itemService.findById(1, 2));
		itemService.delete(1, 2);

	}

}
