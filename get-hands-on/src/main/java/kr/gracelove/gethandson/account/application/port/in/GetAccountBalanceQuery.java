package kr.gracelove.gethandson.account.application.port.in;

/**
 * @author : Eunmo Hong
 * @since : 2020/12/29
 */

public interface GetAccountBalanceQuery {
	Money getAccountBalance(AccountId accountId);
}
