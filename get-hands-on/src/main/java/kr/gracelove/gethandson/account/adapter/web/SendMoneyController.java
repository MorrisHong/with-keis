package kr.gracelove.gethandson.account.adapter.web;

import kr.gracelove.gethandson.account.application.port.in.SendMoneyCommand;
import kr.gracelove.gethandson.account.application.port.in.SendMoneyUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Eunmo Hong
 * @since : 2020/12/29
 */

@RestController
@RequiredArgsConstructor
public class SendMoneyController {
	private final SendMoneyUseCase sendMoneyUseCase;

	@PostMapping("accounts/send/{sourceAccountId}/{targetAccountId}/{amount}")
	void sendMoney(@PathVariable("sourceAccountId") Long sourceAccountId,
	               @PathVariable("targetAccountId") Long targetAccountId,
	               @PathVariable("amount") Long amount) {
		SendMoneyCommand command = new SendMoneyCommand(
				new AccountId(sourceAccountId),
				new AccountId(targetAccountId),
				Money.of(amount)
		);

		sendMoneyUseCase.sendMoney(command);
	}
}
