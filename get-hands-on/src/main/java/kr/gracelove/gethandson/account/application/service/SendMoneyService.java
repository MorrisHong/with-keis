package kr.gracelove.gethandson.account.application.service;

import kr.gracelove.gethandson.account.application.port.in.SendMoneyCommand;
import kr.gracelove.gethandson.account.application.port.in.SendMoneyUseCase;
import kr.gracelove.gethandson.account.application.port.out.LoadAccountPort;
import kr.gracelove.gethandson.account.application.port.out.UpdateAccountStatePort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : Eunmo Hong
 * @since : 2020/12/27
 */

@RequiredArgsConstructor
@Transactional
public class SendMoneyService implements SendMoneyUseCase {

	private final LoadAcㅁcountPort loadAccountPort;
	private final AccountLock accountLock;
	private final UpdateAccountStatePort updateAccountStatePort;

	@Override
	public boolean sendMoney(SendMoneyCommand command) {
		// todo : validate business rules
		// todo : manipulate model state
		// todo : return output
		return false;
	}
}
