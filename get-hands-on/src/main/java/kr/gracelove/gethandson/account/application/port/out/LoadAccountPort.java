package kr.gracelove.gethandson.account.application.port.out;

import kr.gracelove.gethandson.account.domain.Account;

import java.time.LocalDateTime;

/**
 * @author : Eunmo Hong
 * @since : 2020/12/27
 */

public interface LoadAccountPort {
	Account loadAccount(AccountId accountId, LocalDateTime baselineDate);
}
