package peaksoft.repository;

import peaksoft.model.Appointment;
import peaksoft.model.Department;

import java.util.List;

public interface AppointmentRepository {
    List<Appointment> getAllAppointment(Long appointmentId);

    void saveAppointment(Appointment appointment);

    Appointment getAppointmentById(Long id);

    void deleteAppointmentById(Long id);

    void updateAppointment(Long appointmentId,Appointment appointment);
}
