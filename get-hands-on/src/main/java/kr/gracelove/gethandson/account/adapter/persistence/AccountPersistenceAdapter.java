package kr.gracelove.gethandson.account.adapter.persistence;

import kr.gracelove.gethandson.account.adapter.persistence.AccountJpaEntity;
import kr.gracelove.gethandson.account.adapter.persistence.ActivityRepository;
import kr.gracelove.gethandson.account.application.port.out.LoadAccountPort;
import kr.gracelove.gethandson.account.application.port.out.UpdateAccountStatePort;
import kr.gracelove.gethandson.account.domain.Account;
import kr.gracelove.gethandson.account.domain.Activity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author : Eunmo Hong
 * @since : 2020/12/27
 */

@RequiredArgsConstructor
@Component
public class AccountPersistenceAdapter implements LoadAccountPort, UpdateAccountStatePort {

	private final AccountRepository accountRepository;
	private final ActivityRepository activityRepository;
	private final AccountMapper accountMapper;

	@Override
	public Account loadAccount(AccountId accountId,
	                           LocalDateTime baselineDate) {
		AccountJpaEntity account = accountRepository.findById(accountId.getValue())
				.orElseThrow(EntityNotFoundException::new);

		List<ActivityJpaEntity> activities = activityRepository.findByOwnerSince(accountId.getValue(), baselineDate);

		Long withdrawalBalance = orZero(activityRepository.getWithdrawalBalanceUntil(accountId.getValue(), baselineDate));

		Long depositBalance = orZero(activityRepository.getDepositBalanceUntil(accountId.getValue(), baselineDate));

		return accountMapper.mapToDomainEntity(account, activities, withdrawalBalance, depositBalance);

	}

	private Long orZero(Long value) {
		return value == null ? 0L : value;
	}

	@Override
	public void updateActivities(Account account) {
		for (Activity activity : account.getActivityWindow().getActivities()) {
			if (activity.getId() == null) {
				activityRepository.save(accountMapper.mapToJpaEntity(activity));
			}
		}
	}
}
