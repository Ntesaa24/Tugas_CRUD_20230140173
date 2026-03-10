const API_URL = '/ktp';

$(document).ready(function () {
    console.log('App initialized');
    loadKtp();

    $('#ktp-form').on('submit', function (e) {
        e.preventDefault();
        saveKtp();
    });

    $('#cancel-btn').on('click', function () {
        resetForm();
    });

    // Use event delegation for dynamic buttons
    $(document).on('click', '.btn-edit', function () {
        const id = $(this).data('id');
        console.log('Edit clicked for ID:', id);
        editKtp(id);
    });

    $(document).on('click', '.btn-delete', function () {
        const id = $(this).data('id');
        console.log('Delete clicked for ID:', id);
        deleteKtp(id);
    });
});

function loadKtp() {
    $.ajax({
        url: API_URL,
        type: 'GET',
        success: function (response) {
            console.log('Load success:', response);
            if (response.success) {
                renderTable(response.data);
            }
        },
        error: function (xhr) {
            console.error('Load error:', xhr);
            showNotification(xhr.responseJSON?.message || 'Failed to load records', 'error');
        }
    });
}

function renderTable(data) {
    const tbody = $('#ktp-list');
    tbody.empty();

    if (!data || data.length === 0) {
        tbody.append('<tr><td colspan="6" style="text-align:center;">No records found</td></tr>');
        return;
    }

    data.forEach(ktp => {
        tbody.append(`
            <tr>
                <td><strong>${ktp.nomorKtp}</strong></td>
                <td>${ktp.namaLengkap}</td>
                <td>${ktp.alamat}</td>
                <td>${ktp.tanggalLahir}</td>
                <td><span class="badge">${ktp.jenisKelamin}</span></td>
                <td>
                    <button class="btn btn-edit" data-id="${ktp.id}">Edit</button>
                    <button class="btn btn-danger btn-delete" data-id="${ktp.id}">Delete</button>
                </td>
            </tr>
        `);
    });
}

function saveKtp() {
    const id = $('#ktp-id').val();
    const ktpData = {
        nomorKtp: $('#nomorKtp').val(),
        namaLengkap: $('#namaLengkap').val(),
        alamat: $('#alamat').val(),
        tanggalLahir: $('#tanggalLahir').val(),
        jenisKelamin: $('#jenisKelamin').val()
    };

    console.log('Saving KTP:', ktpData, 'ID:', id);

    const type = id ? 'PUT' : 'POST';
    const url = id ? `${API_URL}/${id}` : API_URL;

    $.ajax({
        url: url,
        type: type,
        contentType: 'application/json',
        data: JSON.stringify(ktpData),
        success: function (response) {
            console.log('Save success:', response);
            showNotification(response.message, 'success');
            resetForm();
            loadKtp();
        },
        error: function (xhr) {
            console.error('Save error:', xhr);
            const errorData = xhr.responseJSON;
            let message = errorData?.message || 'Error occurred';
            if (errorData?.data && typeof errorData.data === 'object') {
                message = Object.values(errorData.data).join(', ');
            }
            showNotification(message, 'error');
        }
    });
}

function editKtp(id) {
    if (!id) return;

    $.ajax({
        url: `${API_URL}/${id}`,
        type: 'GET',
        success: function (response) {
            console.log('Fetch KTP for edit success:', response);
            if (response.success) {
                const data = response.data;
                $('#ktp-id').val(data.id);
                $('#nomorKtp').val(data.nomorKtp);
                $('#namaLengkap').val(data.namaLengkap);
                $('#alamat').val(data.alamat);
                $('#tanggalLahir').val(data.tanggalLahir);
                $('#jenisKelamin').val(data.jenisKelamin);

                $('#form-title').text('Edit KTP Record');
                $('#submit-btn').text('Update Record');
                $('#cancel-btn').show();

                // Scroll to form
                $('html, body').animate({
                    scrollTop: $(".form-section").offset().top - 20
                }, 500);
            }
        },
        error: function (xhr) {
            console.error('Edit fetch error:', xhr);
            showNotification('Failed to fetch record details', 'error');
        }
    });
}

function deleteKtp(id) {
    if (!id) return;

    if (confirm('Are you sure you want to delete this record?')) {
        $.ajax({
            url: `${API_URL}/${id}`,
            type: 'DELETE',
            success: function (response) {
                console.log('Delete success:', response);
                showNotification(response.message, 'success');
                loadKtp();
            },
            error: function (xhr) {
                console.error('Delete error:', xhr);
                showNotification(xhr.responseJSON?.message || 'Delete failed', 'error');
            }
        });
    }
}

function resetForm() {
    $('#ktp-form')[0].reset();
    $('#ktp-id').val('');
    $('#form-title').text('Add New KTP');
    $('#submit-btn').text('Save Record');
    $('#cancel-btn').hide();
}

function showNotification(message, type) {
    const notification = $('#notification');
    notification.text(message);
    notification.attr('class', `notification ${type} show`);

    setTimeout(() => {
        notification.removeClass('show');
    }, 4000);
}
