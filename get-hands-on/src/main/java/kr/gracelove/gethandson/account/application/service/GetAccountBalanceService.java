package kr.gracelove.gethandson.account.application.service;

import kr.gracelove.gethandson.account.application.port.in.GetAccountBalanceQuery;
import kr.gracelove.gethandson.account.application.port.out.LoadAccountPort;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author : Eunmo Hong
 * @since : 2020/12/29
 */

@RequiredArgsConstructor
public class GetAccountBalanceService implements GetAccountBalanceQuery {
	private final LoadAccountPort loadAccountPort;


	@Override
	public Money getAccountBalance(AccountId accountId) {
		return loadAccountPort.loadAccount(accountId, LocalDateTime.now())
				.calculateBalance();
	}
}
