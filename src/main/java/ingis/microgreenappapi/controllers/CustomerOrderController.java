package ingis.microgreenappapi.controllers;

import ingis.microgreenappapi.data.CustomerRepository;
import ingis.microgreenappapi.data.OrderDetailsRepository;
import ingis.microgreenappapi.models.Customer;
import ingis.microgreenappapi.service.OrderFormService;
import org.springframework.web.bind.annotation.CrossOrigin;
import ingis.microgreenappapi.exception.ResourceNotFoundException;
import ingis.microgreenappapi.models.CustomerOrder;
import ingis.microgreenappapi.data.CustomerOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*")
public class CustomerOrderController {

    @Autowired
    private OrderFormService orderFormService;

    @Autowired
    private  CustomerOrderRepository customerOrderRepository;
    @GetMapping()
    public ResponseEntity<List<CustomerOrder>> getAllOrders() {
        List<CustomerOrder> customerOrders = orderFormService.getAllOrders();
        return new ResponseEntity<>(customerOrders, HttpStatus.OK);
    }
    @GetMapping("/{orderId}")
    public ResponseEntity<CustomerOrder> getOrderById(@PathVariable Integer orderId){
        CustomerOrder customerOrder = customerOrderRepository.findById(orderId)
                .orElseThrow(()->new ResourceNotFoundException("Customer Order does not exist with id:" + orderId));
        return ResponseEntity.ok(customerOrder);
    }
    @PostMapping("/create")
    public ResponseEntity<CustomerOrder> addOrder(@RequestBody CustomerOrder customerOrder) {
        CustomerOrder order = orderFormService.addOrder(customerOrder);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
    @PutMapping("/update/{orderId}")
    public ResponseEntity<CustomerOrder> updateOrder(@PathVariable Integer orderId, @RequestBody CustomerOrder customerOrder) {
       orderFormService.editOrder(orderId, customerOrder);
        return new ResponseEntity<>(customerOrder, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable Integer orderId) {
        orderFormService.deleteOrder(orderId);
        return new ResponseEntity<>("Customer order with ID :" + orderId + " deleted successfully", HttpStatus.OK);
    }

}




