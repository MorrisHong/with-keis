package kr.gracelove.gethandson.account.adapter;

import kr.gracelove.gethandson.account.adapter.persistence.AccountPersistenceAdapter;
import kr.gracelove.gethandson.account.adapter.persistence.ActivityRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author : Eunmo Hong
 * @since : 2020/12/31
 */

@Configuration
@EnableJpaRepositories
public class PersistenceAdapterConfiguration {

	@Bean
	AccountPersistenceAdapter accountPersistenceAdapter(AccountRepository accountRepository,
	                                                    ActivityRepository activityRepository,
	                                                    AccountMapper accountMapper) {
		return new AccountPersistenceAdapter(accountRepository, activityRepository, accountMapper);
	}

	@Bean
	AccountMapper accountMapper() {
		return new AccountMapper();
	}
}
