package kr.gracelove.gethandson.account.application.port.out;

import kr.gracelove.gethandson.account.domain.Account;

/**
 * @author : Eunmo Hong
 * @since : 2020/12/27
 */

public interface UpdateAccountStatePort {
	void updateActivities(Account account);
}
