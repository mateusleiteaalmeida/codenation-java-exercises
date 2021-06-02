package challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuoteServiceImpl implements QuoteService {

	@Autowired
	private QuoteRepository repository;

	@Override
	public Quote getQuote() {
		List<Quote> quotesList = (List<Quote>) repository.findAll();
		Random rand = new Random();
		return quotesList.get(rand.nextInt(quotesList.size()));
	}

	@Override
	public Quote getQuoteByActor(String actor) {
		List<Quote> actorsList = repository.findByActor(actor);
		Random rand = new Random();
		return actorsList.get(rand.nextInt(actorsList.size()));
	}

}
