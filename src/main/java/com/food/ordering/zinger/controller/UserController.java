package com.food.ordering.zinger.controller;

import com.food.ordering.zinger.column.UserColumn;
import com.food.ordering.zinger.model.UserCollegeModel;
import com.food.ordering.zinger.model.UserModel;
import com.food.ordering.zinger.model.UserShopListModel;
import com.food.ordering.zinger.service.UserService;
import com.food.ordering.zinger.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/customer")
    public Response<UserCollegeModel> loginRegisterCustomer(@RequestBody UserModel user) {
        return userService.loginRegisterCustomer(user);
    }

    @PostMapping(value = "/seller")
    public Response<UserShopListModel> verifySeller(@RequestBody UserModel user) {
        return userService.verifySeller(user);
    }

    @PostMapping(value = "/seller/{shopId}/{mobile}")
    public Response<String> insertSeller(@PathVariable("shopId") Integer shopId, @PathVariable("mobile") String mobile, @RequestHeader(value = UserColumn.oauthId) String oauthId, @RequestHeader(value = UserColumn.mobile) String mobileRh, @RequestHeader(value = UserColumn.role) String role) {
        return userService.insertSeller(shopId, mobile, oauthId, mobileRh, role);
    }

    /**************************************************/

    @GetMapping(value = "/seller/{shopId}")
    public Response<List<UserModel>> getSellerByShopId(@PathVariable("shopId") Integer shopId, @RequestHeader(value = UserColumn.oauthId) String oauthId, @RequestHeader(value = UserColumn.mobile) String mobileRh, @RequestHeader(value = UserColumn.role) String role) {
        return userService.getSellerByShopId(shopId, oauthId, mobileRh, role);
    }

    /**************************************************/

    @PatchMapping(value = "")
    public Response<String> updateUser(@RequestBody UserModel userModel, @RequestHeader(value = UserColumn.oauthId) String oauthId, @RequestHeader(value = UserColumn.mobile) String mobile, @RequestHeader(value = UserColumn.role) String role) {
        return userService.updateUser(userModel, oauthId, mobile, role);
    }

    @PatchMapping(value = "/college")
    public Response<String> updateUserCollegeData(@RequestBody UserCollegeModel userCollegeModel, @RequestHeader(value = UserColumn.oauthId) String oauthId, @RequestHeader(value = UserColumn.mobile) String mobile, @RequestHeader(value = UserColumn.role) String role) {
        return userService.updateUserCollegeData(userCollegeModel, oauthId, mobile, role);
    }

    /**************************************************/

    @DeleteMapping(value = "/seller/{shopId}/{mobile}")
    public Response<String> deleteSeller(@PathVariable("shopId") Integer shopId, @PathVariable("mobile") String mobile, @RequestHeader(value = UserColumn.oauthId) String oauthId, @RequestHeader(value = UserColumn.mobile) String mobileRh, @RequestHeader(value = UserColumn.role) String role) {
        return userService.deleteSeller(shopId, mobile, oauthId, mobileRh, role);
    }
}
