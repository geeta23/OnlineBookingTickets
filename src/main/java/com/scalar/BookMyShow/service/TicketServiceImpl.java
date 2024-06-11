package com.scalar.BookMyShow.service;

import com.scalar.BookMyShow.exception.ShowSeatNotAvailableException;
import com.scalar.BookMyShow.models.BmsUser;
import com.scalar.BookMyShow.models.ShowSeat;
import com.scalar.BookMyShow.models.Ticket;
import com.scalar.BookMyShow.models.constants.ShowSeatStatus;
import com.scalar.BookMyShow.repository.ShowSeatRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService{
    @Autowired
    private ShowSeatRepository showSeatRepository; // spring will directly create the repository object
// get clicked seat ID's from front end.
    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    // this method will behave a tnx now, so any query that will hit the db and use this method
    // will be serialized at database level
    public Ticket bookTicket(List<Integer> showSeatIds, Integer bmsUserId) throws ShowSeatNotAvailableException {
        // check status of all seats, if anyone of the not available throw exceptions
        for(Integer showSeatId : showSeatIds){
            // should do a bulk save and bulk read to avoid cross booking
            ShowSeat showSeat = showSeatRepository.findById(showSeatId).get();
            // as findById Returns optional
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)) {
                throw new ShowSeatNotAvailableException("This seat id:" + showSeatId + "is not available");
            }
        }

        // locking the seats
        for(Integer showSeatId : showSeatIds){
            ShowSeat showSeat = showSeatRepository.findById(showSeatId).get();
            showSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            // while saving do a pessimistic lock, so that no one can neither read or write ShowSeat
            showSeatRepository.save(showSeat);
        }
        // have to add payment and creation of ticket code
        return new Ticket();
    }

    // this won't follow isolation method
    void ExampleMethod(){}
}
