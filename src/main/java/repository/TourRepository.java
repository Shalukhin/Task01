package repository;

import entity.tour.Tour;

public interface TourRepository extends Repository<Tour> {
	
	Tour findById(int id);
}
