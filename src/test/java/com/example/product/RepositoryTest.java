package com.example.product;

import com.example.product.repository.BrandRepository;
import com.example.product.repository.OptionDetailRepository;
import com.example.product.repository.OptionRepository;
import com.example.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Sql(scripts = {"/data.sql"})
@ActiveProfiles("test")
public class RepositoryTest {

    @Autowired
    protected ProductRepository productRepository;

    @Autowired
    protected BrandRepository brandRepository;

    @Autowired
    protected OptionRepository optionRepository;

    @Autowired
    protected OptionDetailRepository optionDetailRepository;

}
