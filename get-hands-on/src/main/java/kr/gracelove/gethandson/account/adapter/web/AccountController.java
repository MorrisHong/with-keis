package kr.gracelove.gethandson.account.adapter.web;

import kr.gracelove.gethandson.account.application.port.in.GetAccountBalanceQuery;
import kr.gracelove.gethandson.account.application.port.in.SendMoneyUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Eunmo Hong
 * @since : 2020/12/27
 */

@RequiredArgsConstructor
@RestController
public class AccountController {
	private final GetAccountBalanceQuery getAccountBalanceQuery;
	private final ListAccountQuery listAccountQuery;
	private final LoadAccountQuery loadAccountQuery;
	private final SendMoneyUseCase sendMoneyUseCase;
	private final CreateAccountUseCase createAccountUseCase;

	@GetMapping("/accounts")
	List<AccountResource> listAccounts() {

	}

	@GetMapping("/account/{accountId}")
	AccountResource getAccount(@PathVariable("accountId") Long accountId) {

	}

	@GetMapping("/accounts/{accountId}/balance")
	long getAccountBalance(@PathVariable("accountId") Long accountId) {

	}

	@PostMapping("/accounts")
	AccountResource createAccount(@RequestBody AccountResource accountResource) {

	}

//	@PostMapping("accounts/send/{sourceAccountId}/{targetAccountId}/{amount}")
//	void sendMoney(@PathVariable("sourceAccountId") Long sourceAccountId,
//	               @PathVariable("targetAccountId") Long targetAccountId,
//	               @PathVariable("amount") Long amount) {
//
//	}
//}
