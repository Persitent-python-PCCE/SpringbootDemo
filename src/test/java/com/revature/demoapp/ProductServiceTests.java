package com.revature.demoapp;

import com.revature.demoapp.models.Product;
import com.revature.demoapp.repository.ProductRepository;
import com.revature.demoapp.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTests {
    @Mock
    ProductRepository mock_repo;//all moethods need to be stubbbed
//    ProductRepository repo = Mockito.mock(ProductRepository.class);
    @Spy
    ProductRepository spy_repo;//you can stub selectively
    @InjectMocks
    ProductService service;

    @Test
    void testUpdateProduct(){
        Product pr = new Product(1L,"watch", 2000.00, 22);
        when(mock_repo.findById(1L)).thenReturn(Optional.of(pr));
//        when(mock_repo.findById(2L)).thenReturn(Optional.of(new Product(2L, "shoes", 3000.00, 10)));
        when(mock_repo.save(pr)).thenReturn(pr);
        Product res = service.updateProduct(1L, pr);
        Assertions.assertThrows(RuntimeException.class,() -> service.updateProduct(2L, new Product()) );
        ArgumentCaptor<Product> captor = ArgumentCaptor.forClass(Product.class);
        Assertions.assertEquals("watch", res.getName());
        Assertions.assertEquals(2000.00, res.getPrice());

        verify(mock_repo).findById(1l);
        verify(mock_repo).save(pr);
        verify(mock_repo).save(captor.capture());

    }

    @Test
    void testGetProductById(){
        Product pr = new Product(1L,"watch", 2000.00, 22);
        when(mock_repo.findById(1L)).thenReturn(Optional.of(pr));
        Product res = service.getProductById(1L);
        Assertions.assertEquals("watch", res.getName());

    }






}
